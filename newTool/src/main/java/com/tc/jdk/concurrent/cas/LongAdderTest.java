package com.tc.jdk.concurrent.cas;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

/**
 * 原子操作，效率比AtomicLong等都要高,解决高并发场景下AtomicLong的cas自旋瓶颈问题
 */
public class LongAdderTest {
    static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) {
        longAdder.add(10);
        System.out.println(longAdder.longValue());
    }
}
