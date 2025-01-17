package com.tc.jdk.concurrent.deadLock;

/**
 * 死锁
 * Object.wait  让当前线程释放锁
 */
public class Test {
    private static final String A = "A";
    private static final String B = "B";

    public static void main(String[] args) {
        Thread threadA = new Thread(() ->{
            synchronized (A) {
                System.out.println("threadA进入A同步块，执行中。。。");
                try {
//                    Thread.sleep(2000);
                    A.wait(5000); // 可以释放锁
                    synchronized (B){
                        System.out.println("threadA进入B同步块，执行中。。。");
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"threadA");

        Thread threadB = new Thread(() ->{
            synchronized (B) {
                System.out.println("threadB进入B同步块，执行中。。。");
                try {
//                    Thread.sleep(2000);
//                    B.wait(5000);
                    synchronized (A){
                        System.out.println("threadB进入A同步块，执行中。。。");
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"threadB");

        threadA.start();
        threadB.start();
    }
}
