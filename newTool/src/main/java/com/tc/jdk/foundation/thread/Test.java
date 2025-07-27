package com.tc.jdk.foundation.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替输出
 * 1、锁：多线程环境
 * 2、条件：根据条件判断哪个线程输出（sychronized+wait+notify    ReentrantLock+Condition）
 */
public class Test {
    private static volatile ArrayBlockingQueue lockObj = new ArrayBlockingQueue<String>(1);

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition contion1 = lock.newCondition(); // 线程1进入的条件队列
    private static final Condition contion2 = lock.newCondition(); // 线程2进入的条件队列

    public static void main(String[] args) throws InterruptedException {
//        new PrintThread2().start();
//        Thread.sleep(2000);
//        new PrintThread1().start();


        new PrintThread3().start();
        Thread.sleep(2000);
        new PrintThread4().start();
    }

    static class PrintThread1 extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lockObj) {
                    if (lockObj.size() == 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        // 打印输出
                        String content = "我的内容";
                        lockObj.add(content);
                        System.out.println(Thread.currentThread().getName() + "打印了" + content);
                        lockObj.notifyAll();
                    }
                    else {
                        try {
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            lockObj.notifyAll();
                        }
                    }
                }
            }
        }
    }


    static class PrintThread2 extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lockObj) {
                    if (lockObj.size() == 0) {
                        try {
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            lockObj.notifyAll();
                        }
                    }
                    else {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        // 打印输出
                        String content = (String) lockObj.poll();
                        System.out.println(Thread.currentThread().getName() + "打印了" + content);
                        lockObj.notifyAll();
                    }
                }

            }
        }
    }


    static class PrintThread3 extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (lockObj.size() == 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        // 打印输出
                        String content = "我的内容";
                        lockObj.add(content);
                        System.out.println(Thread.currentThread().getName() + "打印了" + content);
                        contion2.signal();
                        contion1.await();
                    }
                    else {
                        contion1.await();
                        contion2.signal();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        }
    }


    static class PrintThread4 extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (lockObj.size() == 0) {
                        contion2.await();
                        contion1.signal();
                    }
                    else {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        // 打印输出
                        String content = (String) lockObj.poll();
                        System.out.println(Thread.currentThread().getName() + "打印了" + content);
                        contion1.signal();
                        contion2.await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        }
    }


}
