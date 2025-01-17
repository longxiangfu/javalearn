package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock.tryLock(3, TimeUnit.SECONDS)   // 获取不到锁就返回false,有超时时间
 */
public class MyThreadReentrantLock5 {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            try {
                if (!lock.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println("t1线程等待1秒后获取锁失败，返回");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        });

        lock.lock();
        try {
            System.out.println("主线程获取到锁");
            t1.start();
            Thread.sleep(2000);
        }finally {
            lock.unlock();
        }

    }

}
