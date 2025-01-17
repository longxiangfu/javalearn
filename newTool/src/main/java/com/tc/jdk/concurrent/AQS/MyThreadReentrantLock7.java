package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock源码学习
 * lock.lock();    lock.unlock();
 */
public class MyThreadReentrantLock7 {
    private static int sum = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    System.out.println("aaa");
                    for (int j = 0; j < 10000; j++) {
                        sum++;
                    }
                }finally {
                    lock.unlock();
                }
            }, "tread"+i);
            thread.start();
        }

        Thread.sleep(2000);
        System.out.println("sum:" + sum);

    }
}
