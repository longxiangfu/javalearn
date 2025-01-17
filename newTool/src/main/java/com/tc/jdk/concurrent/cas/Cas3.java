package com.tc.jdk.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子数组
 */
public class Cas3 {
    static int[] value = new int[]{1, 2, 3, 4, 5};
    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        atomicIntegerArray.set(0, 100);
        atomicIntegerArray.getAndAdd(1, 5);
        System.out.println(atomicIntegerArray); // [100, 7, 3, 4, 5]
    }
}
