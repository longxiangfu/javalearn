package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.Semaphore;

/**
 * Semaphore:信号量
 * 1、acquire():获取信号量
 * 2、release():释放信号量
 * 3、例子：车位
 */
public class SemaphoreDemo3 {
    private static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() ->{
                try {
                    //获取信号量，抢到之前一直阻塞
                    semaphore.acquire();
                    System.out.println("抢到车位的是：" + Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放信号量
                    semaphore.release();
                }

            }).start();
        }
    }
}
