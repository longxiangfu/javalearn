package com.tc.jdk.concurrent.multiThread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * volatile关键字
 * 保证可见性
 */
public class VolatileDemo {
    private static boolean flag = true;
    private static volatile boolean flag2 = true;
    private static AtomicBoolean flag3  = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {
//        VolatileDemo.noVolatileTest();
//        VolatileDemo.volatileTest();
//        VolatileDemo.reentrantLockTest();
        VolatileDemo.casTest();
    }

    public static void noVolatileTest() throws InterruptedException {
        new Thread(()->{
            while (flag) {

            }
            System.out.println("子线程结束");
        }).start();

        Thread.sleep(1000);
        flag = false;
        System.out.println("主线程结束");

        // 结果为主线程打印出“主线程结束”后，进程一直不结束，原因在于子线程一直在where true的循环中
        // jvm内存模型JMM, 主线程修改flag=false后，将修改后的值刷新到主内存中，但是子线程并没有发现值的变化，因为子线程本地内存
        // 中的flag值还是true，所以子线程一直在where true的循环
    }


    public static void volatileTest() throws InterruptedException {
        new Thread(()->{
            while (flag2) {

            }
            System.out.println("子线程结束");
        }).start();

        Thread.sleep(1000);
        flag2 = false;
        System.out.println("主线程结束");

        // 结果为主线程打印出“主线程结束”后，子线程打印出“子线程结束”
        // jvm内存模型JMM, 主线程修改flag=false后执行lock前缀指令，在lock前缀指令之前的写操作都必须完成，
        // 并且所有写操作的结果都要刷新到主内存中，清空所有本地内存中的变量副本，读操作都要重新去主内存中取值，所以子线程发现flag2=false，跳出了循环
    }


    public static void reentrantLockTest() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            while (flag) {

            }
            System.out.println("子线程结束");
        }).start();

        Thread.sleep(1000);

        try {
            lock.lock();
            flag = false;
        } catch (Exception e) {

        }finally {
            lock.unlock();
        }

        System.out.println("主线程结束");

        // 程序不终止
        // ReentrantLock在共享不加volatile时，不能保证可见性。ReentrantLock只能保证原子性
    }


    public static void casTest() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            while (flag3.get()) {

            }
            System.out.println("子线程结束");
        }).start();

        Thread.sleep(1000);

        flag3.compareAndSet(true, false);

        System.out.println("主线程结束");

        // 程序终止
        // cas在共享资源不加volatile的情况，也可以保证可见性。cas是线程安全的，即可以保证可见性、有序性、原子性
    }

}
