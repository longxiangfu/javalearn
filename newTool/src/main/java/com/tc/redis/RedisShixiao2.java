package com.tc.redis;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 缓存失效
 * 解决方案：给key设置随机的超时时间
 */
public class RedisShixiao2 {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);

        RBucket<String> bucket = redisson.getBucket("key");
        String value = bucket.get();
        if (StringUtils.isBlank(value)) {
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
            // 返回从数据库查到的值
//            return value;
        }
        // 缓存中有，返回value
//        return value;

        redisson.shutdown();

    }

}
