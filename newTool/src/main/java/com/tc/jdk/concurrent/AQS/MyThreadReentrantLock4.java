package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 等待可中断  ReentrantLock.lockInterruptibly
 * 用于线程协作
 * 线程a和线程b同时执行任务，线程a先执行完后，就不需要线程b再继续执行了
 */
public class MyThreadReentrantLock4 {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            try {
                lock.lockInterruptibly(); // t1等锁，被阻塞
                try{
                    System.out.println("t1线程获取锁");
                }finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("t1等锁的过程中被中断"); // t1可以执行一些收尾工作
            }
        });

        lock.lock();
        try {
            System.out.println("main线程获取锁");
            t1.start(); // t1开始
            Thread.sleep(2000); // 模拟线程t1执行一段时间
            t1.interrupt(); // t1被中断
            System.out.println("t1线程执行中断");
        }finally {
            lock.unlock();
        }


//        main线程获取锁
//        java.lang.InterruptedException
//        at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireInterruptibly(AbstractQueuedSynchronizer.java:898)
//        at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireInterruptibly(AbstractQueuedSynchronizer.java:1222)
//        at java.util.concurrent.locks.ReentrantLock.lockInterruptibly(ReentrantLock.java:335)
//        at com.tc.jdk.concurrent.AQS.MyThreadReentrantLock4.lambda$main$0(MyThreadReentrantLock4.java:14)
//        at java.lang.Thread.run(Thread.java:750)
//        t1等锁的过程中被中断
//        t1线程执行中断

    }
}
