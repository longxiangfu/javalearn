package com.tc.jdk.foundation.thread;

/**
 * Thread.yield()
 * 当前线程让出cpu执行权，进入就绪状态，等待cpu调度。
 */
public class YieldTest {
    public static void main(String[] args) throws InterruptedException {
        Thread yieldThread = new Thread(() ->{
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (i == 10){
                    Thread.yield();
                }
                System.out.println(i);

            }
        });
        yieldThread.start();

    }
}
