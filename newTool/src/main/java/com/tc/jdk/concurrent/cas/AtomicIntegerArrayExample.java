package com.tc.jdk.concurrent.cas;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * 原子数组
 * AtomicIntegerArray   AtomicLongArray  AtomicDoubleArray  AtomicReferenceArray
 * 这个例子展示了如何使用 AtomicIntegerArray 来确保对整数数组元素的修改是原子的，避免了多线程环境下的竞态条件。
 * 最终，每个数组元素的值应该是 100（10 个线程，每个线程增加 100 次）。
 */
public class AtomicIntegerArrayExample {
    // 创建一个 AtomicIntegerArray 实例，初始值为 0
    private static final AtomicIntegerArray array = new AtomicIntegerArray(10);
    private static final AtomicLongArray array1 = new AtomicLongArray(10);
    private static final AtomicReferenceArray<Person> array2 = new AtomicReferenceArray<>(new Person[]{new Person("lxf")});

    public static void main(String[] args) {
        // 创建多个线程来增加数组中元素的值
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    array.incrementAndGet(index); // 原子地增加数组中指定索引位置的值
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

        // 输出最终的数组值
        System.out.println("Final array values:");
        for (int i = 0; i < array.length(); i++) {
            System.out.println("Index " + i + ": " + array.get(i));
        }
    }
}
