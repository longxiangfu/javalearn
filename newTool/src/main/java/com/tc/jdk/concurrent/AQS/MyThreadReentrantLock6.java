package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁和非公平锁
 * 非公平锁在高并发场景下效率高
 * 非公平锁允许后来的线程直接尝试获取锁，如果此时锁状态正好可用，则该线程可以立即获取到锁继续执行
 */
public class MyThreadReentrantLock6 {
    // 公平锁，线程按启动顺序排队依次获取锁
//    private static final ReentrantLock lock = new ReentrantLock(true);
    // 非公平锁，后启动的线程可能先获取锁
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 500; i++) {
            new Thread(() ->{
                lock.lock();
                try{
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName()+" running...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }, "t"+i).start();
        }

        Thread.sleep(1000);

        for (int i = 0; i < 500; i++) {
            new Thread(() ->{
                lock.lock();
                try{
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName()+" running...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }, "强行插入"+i).start();
        }


//        t42 running...
//        t65 running...
//        t66 running...
//        强行插入312 running...
//        t68 running...
//        t47 running...
//        t96 running...
//        t71 running...
    }
}
