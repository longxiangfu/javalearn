package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入 : 一个线程可以重复获取同一把锁
 */
public class MyThreadReentrantLock3 {
    public static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        method1();
//        执行method1
//        当前重入数：1
//        执行method2
//        当前重入数：2
//        执行method3
//        当前重入数：3
    }

    private static void method1() throws InterruptedException {
        lock.lock();
        try{
            System.out.println("执行method1");
            System.out.println("当前重入数：" + lock.getHoldCount()); // 当前重入数：1
            Thread.sleep(1000);
            method2();
        }finally {
            lock.unlock();
        }
    }

    private static void method2() throws InterruptedException {
        lock.lock();
        try{
            System.out.println("执行method2");
            System.out.println("当前重入数：" + lock.getHoldCount()); // 当前重入数：2
            Thread.sleep(1000);
            method3();
        }finally {
            lock.unlock();
        }
    }

    private static void method3() {
        lock.lock();
        try{
            System.out.println("执行method3");
            System.out.println("当前重入数：" + lock.getHoldCount()); // 当前重入数：3
        }finally {
            lock.unlock();
        }
    }
}
