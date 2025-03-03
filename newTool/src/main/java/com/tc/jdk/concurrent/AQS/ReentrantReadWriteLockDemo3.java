package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 读读不互斥
 * 读写、写读、写写互斥
 */
public class ReentrantReadWriteLockDemo3 {
    private static final MyReadWriteLock myReadWriteLock = new MyReadWriteLock();
    public static void main(String[] args) throws InterruptedException {
//        readReadTest();
//        writeWriteTest();
//        readWriteTest();
        writeReadTest();
    }

    public static void readReadTest() throws InterruptedException {
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

//        读取进入|线程r1
//        读取进入|线程r2
//        读取退出|线程r1
//        读取退出|线程r2
    }
    public static void writeWriteTest() throws InterruptedException {
        Thread r1 = new Thread(() ->{
            myReadWriteLock.write();
        }, "r1");
        Thread r2 = new Thread(() ->{
            myReadWriteLock.write();
        }, "r2");
        r1.start();
        r2.start();
        r1.join(); // 主线程等待r1线程结束
        r2.join();

//        写入进入|线程r1
//        写入退出|线程r1
//        写入进入|线程r2
//        写入退出|线程r2
    }
    public static void readWriteTest() throws InterruptedException {
        Thread r1 = new Thread(() ->{
            myReadWriteLock.read();
        }, "r1");
        r1.start();

        Thread.sleep(2000);

        Thread r2 = new Thread(() ->{
            myReadWriteLock.write();
        }, "r2");
        r2.start();

        r1.join(); // 主线程等待r1线程结束
        r2.join();

//        读取进入|线程r1
//        读取退出|线程r1
//        写入进入|线程r2
//        写入退出|线程r2
    }
    public static void writeReadTest() throws InterruptedException {
        Thread r1 = new Thread(() ->{
            myReadWriteLock.write();
        }, "r1");
        r1.start();

        Thread.sleep(1000);

        Thread r2 = new Thread(() ->{
            myReadWriteLock.read();
        }, "r2");
        r2.start();

        r1.join(); // 主线程等待r1线程结束
        r2.join();

//        写入进入|线程r1
//        写入退出|线程r1
//        读取进入|线程r2
//        读取退出|线程r2
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
