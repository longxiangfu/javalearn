package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 读锁：允许并发读
 * 写锁：不允许并发写
 * 读写锁：读读不互斥，也就说读读可以并发。读写、写读、写写是互斥的。
 */
public class ReentrantReadWriteLockDemo3 {
    private static final MyReadWriteLock myReadWriteLock = new MyReadWriteLock();
    public static void main(String[] args) throws InterruptedException {
        Thread r1 = new Thread(() ->{
            myReadWriteLock.read();
        }, "r1");
        Thread r2 = new Thread(() ->{
            myReadWriteLock.read();
        }, "r2");
        r1.start();
        r2.start();
        r1.join(); // 主线程等待r1线程结束
        r2.join();

        new Thread(() ->{
            myReadWriteLock.write();
        }, "w1").start();
        new Thread(() ->{
            myReadWriteLock.write();
        }, "w2").start();

        // 允许并发读
//        读取进入|线程r1
//        读取进入|线程r2
//        读取退出|线程r2
//        读取退出|线程r1
        // 不允许并发写
//        写入进入|线程w1
//        写入退出|线程w1
//        写入进入|线程w2
//        写入退出|线程w2
    }


    private static class MyReadWriteLock{
        private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public void read(){
            try{
                //加读锁
                lock.readLock().lock();
                System.out.println("读取进入|线程" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
                System.out.println("读取退出|线程" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
        }

        public void write(){
            try {
                //加写锁
                lock.writeLock().lock();
                System.out.println("写入进入|线程" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
                System.out.println("写入退出|线程" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        }

    }
}
