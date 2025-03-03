package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock示例
 */
public class MyReentrantLock1 {
    private static final ReentrantLock lock = new ReentrantLock(true); // 锁
    private static final Condition cigCon = lock.newCondition(); // 有烟条件
    private static final Condition takeCon = lock.newCondition(); // 有饭条件

    // 不用加volatile，因为线程在切换回后，会从主内存中重新加载该变量
    private static boolean hascig = false; // 有烟
    private static boolean hastakeout = false; // 有饭

    public void cigratee() {
        // 获取到锁
        lock.lock();
        try {
            while (!hascig) { // 判断共享变量
                System.out.println("没有烟，歇一会");
                try {
                    // 调用条件队列的await方法，释放锁，进入条件队列
                    cigCon.await();
                    // 其他线程调用了cigCon.signal(), 将当前线程从条件队列中移到同步队列队尾，当前线程重新尝试获取锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 当前线程重新获取到锁
            System.out.println("有烟了，干活");
        }finally {
            lock.unlock();
        }
    }

    public void takeout() {
        // 获取到锁
        lock.lock();
        try {
            while (!hastakeout) { // 判断共享变量
                System.out.println("没有饭，歇一会");
                try {
                    // 调用条件队列的await方法，释放锁，进入条件队列
                    takeCon.await();
                    // 其他线程调用了cigCon.signal(), 将当前线程从条件队列中移到同步队列队尾，当前线程重新尝试获取锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 当前线程重新获取到锁
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
                // 调用条件队列的signal方法，选择一个线程移到同步队列队尾，该线程重新尝试获取锁
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
                // 调用条件队列的signal方法，选择一个线程移到同步队列队尾，该线程重新尝试获取锁
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
