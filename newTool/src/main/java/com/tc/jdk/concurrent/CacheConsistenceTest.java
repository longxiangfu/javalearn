package com.tc.jdk.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 缓存一致性造成变量干扰
 */
public class CacheConsistenceTest {

    public static void main(String[] args) {
        Pointer pointer = new Pointer();
        CountDownLatch latch = new CountDownLatch(2);
        long start = System.currentTimeMillis();
        new Thread(() ->{
            for (long i = 0; i < 1000000000; i++) {
                pointer.x++;
            }
            latch.countDown();
        }).start();

        new Thread(() ->{
            for (int i = 0; i < 1000000000; i++) {
                pointer.y++;
            }
            latch.countDown();
        }).start();

        System.out.println("主线程正在等待子线程执行");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程执行完毕");
        long end = System.currentTimeMillis();
        System.out.println(pointer.x + "," + pointer.y);
        System.out.println("消耗时间：" + (end-start) + "ms");
    }


    static class Pointer{
        //当xy都被volatile修饰时， x y在同一个缓存行中，当触发缓存一致性时，会将同一个缓存行都清空掉
        volatile long x;
        volatile long y;

    }

}
