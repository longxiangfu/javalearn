package com.tc.jdk.concurrent.cas;

import com.google.common.util.concurrent.AtomicDouble;
import com.google.common.util.concurrent.AtomicDoubleArray;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicIntegerFieldUpdater   AtomicLongFieldUpdater     AtomicReferenceFieldUpdater
 * 这个例子展示了如何使用 AtomicIntegerFieldUpdater 来确保对类的 volatile int 字段的修改是原子的，避免了多线程环境下的竞态条件。
 * 最终的 count 值应该是 10000（10 个线程，每个线程增加 1000 次）。
 */
public class AtomicIntegerFieldUpdaterExample {
    // 创建一个 AtomicIntegerFieldUpdater 实例
    private static final AtomicIntegerFieldUpdater<Counter> updater =
            AtomicIntegerFieldUpdater.newUpdater(Counter.class, "count");

    public static void main(String[] args) {
        // 创建一个 Counter 实例
        Counter counter = new Counter(0);

        // 创建多个线程来增加 count 字段的值
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    updater.incrementAndGet(counter); // 原子地增加 count 字段的值
                }
            });
            threads[i].start();
        }

        // 等待所有线程完成
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 输出最终的 count 值
        System.out.println("Final count value: " + counter.getCount());
    }
}
