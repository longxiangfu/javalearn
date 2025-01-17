package com.tc.redis;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 缓存不一致
 * 读写锁：读的时候加读锁；写的时候加写锁
 * 读写锁：读读不互斥，也就说读读可以并发。读写、写读、写写是互斥的。
 * 读写锁在同一时刻可以允许多个读线程访问，在写线程访问的时候其他的读线程和写线程都会被阻塞。读写锁维护一对锁(读锁和写锁)，通过锁的分离，使得并发性提高
 */
public class RedisDB4 {

    public static void main(String[] args) {
        getKey();
    }

    private static String getKey() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);

        RReadWriteLock lock = redisson.getReadWriteLock("read_write_key");

        RBucket<String> bucket = redisson.getBucket("key");
        String value = bucket.get();
        if (StringUtils.isBlank(value)) {
            lock.readLock().lock();
            try{
                String value1 = bucket.get();
                if (StringUtils.isBlank(value1)) {
                    lock.readLock().unlock();
                    lock.writeLock().lock();
                    try{
                        // 缓存中为空，查询数据库
                        String dbValue = null;
//            String dbValue = "longxiangfu";
                        // 数据库查询出结果，不论是否为空，都存放到redis
                        // 经测试，redis版本为5.0时，不能设置null，所以null对应的设一个值即可
                        if (StringUtils.isBlank(dbValue)) {
                            dbValue = "empty object";
                            // 设置空对象的超时时间
                            bucket.set(dbValue, 8, TimeUnit.HOURS);
                        }else{
                            // 设置正常key的超时时间。并且超时时间为随机数
                            bucket.set(dbValue, new Random().nextInt(300)+300, TimeUnit.HOURS);
                        }

                        lock.readLock().lock();
                    }finally {
                        lock.writeLock().unlock();
                    }
                    // 返回从数据库查到的值
                    return value;
                }
                return value1;

            }finally {
                lock.readLock().unlock();
            }
        }

        redisson.shutdown();
        // 缓存中有，返回value
        return value;
    }

}
