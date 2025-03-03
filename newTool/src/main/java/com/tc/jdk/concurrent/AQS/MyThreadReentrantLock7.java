package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock源码学习
 * lock.lock();    lock.unlock();
 * 共享资源：可以是类的静态变量。属于类
 * 共享资源：可以是类的实例变量。属于对象的
 * 共享资源：可以是方法内的局部变量。属于方法的
 * 线程安全：多个线程操作共享资源
 */
public class MyThreadReentrantLock7 {
    // 不用volatile修饰，因为线程切换回时，会从主内存中获取sum的值
    private static int sum3 = 0;
    private static final ReentrantLock lock = new ReentrantLock();
    private int sum2;

    public static void main(String[] args) throws InterruptedException {
//        new MyThreadReentrantLock7().test();
//        new MyThreadReentrantLock7().test2();
        new MyThreadReentrantLock7().test3();
    }

    /**
     * 共享变量是局部变量
     * @throws InterruptedException
     */
    public void test() throws InterruptedException {
        final int[] sum = {0};
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    System.out.println("aaa");
                    for (int j = 0; j < 10000; j++) {
                        sum[0]++;
                    }
                }finally {
                    lock.unlock();
                }
            }, "tread"+i);
            thread.start();
        }

        Thread.sleep(2000);
        System.out.println("sum:" + sum[0]);


//        aaa
//        aaa
//        aaa
//        sum:30000
    }

    /**
     * 共享变量是类的实例变量
     * @throws InterruptedException
     */
    public void test2() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    System.out.println("aaa");
                    for (int j = 0; j < 10000; j++) {
                        this.sum2++;
                    }
                }finally {
                    lock.unlock();
                }
            }, "tread"+i);
            thread.start();
        }

        Thread.sleep(2000);
        System.out.println("sum:" + this.sum2);


//        aaa
//        aaa
//        aaa
//        sum:30000
    }

    /**
     * 共享变量是类的静态变量
     * @throws InterruptedException
     */
    public void test3() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    System.out.println("aaa");
                    for (int j = 0; j < 10000; j++) {
                        MyThreadReentrantLock7.sum3++;
                    }
                }finally {
                    lock.unlock();
                }
            }, "tread"+i);
            thread.start();
        }

        Thread.sleep(2000);
        System.out.println("sum:" + MyThreadReentrantLock7.sum3);


//        aaa
//        aaa
//        aaa
//        sum:30000
    }

}
