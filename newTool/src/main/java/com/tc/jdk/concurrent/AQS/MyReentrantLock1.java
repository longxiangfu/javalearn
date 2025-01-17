package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition 条件队列
 */
public class MyReentrantLock1 {
    private static final ReentrantLock lock = new ReentrantLock(true); // 锁
    private static final Condition cigCon = lock.newCondition(); // 有烟条件
    private static final Condition takeCon = lock.newCondition(); // 有饭条件

    // 不用加volatile，因为线程在切换回后，会从主内存中重新加载该变量
    private static boolean hascig = false; // 有烟
    private static boolean hastakeout = false; // 有饭

    public void cigratee() {
        lock.lock();
        try {
            while (!hascig) {
                System.out.println("没有烟，歇一会");
                try {
                    cigCon.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("有烟了，干活");
        }finally {
            lock.unlock();
        }
    }

    public void takeout() {
        lock.lock();
        try {
            while (!hastakeout) {
                System.out.println("没有饭，歇一会");
                try {
                    takeCon.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("有饭了，干活");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyReentrantLock1 myReentrantLock1 = new MyReentrantLock1();
        new Thread(() -> {
            myReentrantLock1.cigratee();
        }, "t1").start();
        new Thread(()-> {
            myReentrantLock1.takeout();
        }, "t2").start();
        new Thread(()-> {
            lock.lock();
            try {
                hascig = true;
                System.out.println("唤醒烟的等待线程");
                cigCon.signal();
            }finally {
                lock.unlock();
            }
        }, "t3").start();
        new Thread(()-> {
            lock.lock();
            try {
                hastakeout = true;
                System.out.println("唤醒饭的等待线程");
                takeCon.signal();
            }finally {
                lock.unlock();
            }
        }, "t4").start();


//        没有烟，歇一会
//        没有饭，歇一会
//        唤醒烟的等待线程
//        有烟了，干活
//        唤醒饭的等待线程
//        有饭了，干活
    }
}
