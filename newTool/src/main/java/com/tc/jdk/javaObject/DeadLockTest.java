package com.tc.jdk.javaObject;

/**
 * 测试死锁
 * 利用jstack查看死锁信息
 */
public class DeadLockTest {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();


    public static void main(String[] args) {
        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("thread1 begain");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println("thread1 end");
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println("thread2 begain");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println("thread2 end");
                    }
                }
            }
        }).start();

        //
        System.out.println("main end");
    }
}
