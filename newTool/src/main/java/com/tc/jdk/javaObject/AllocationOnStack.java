package com.tc.jdk.javaObject;

/**
 * 在栈上分配
 *
 * -XX:+DoEscapeAnalysis  开启逃逸分析   -XX:+EliminateAllocations  开启标量替换
 * 1、 -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
 * 此时user对象在栈上分配，随着方法的结束，对象会自动消除，因此不会产生大量的GC
 *
 * 2、-Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 * -Xmx15m -Xms15m -XX:-DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 * 此时user对象在堆上分配，会产生大量的GC
 */
public class AllocationOnStack {
    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
    }

    private static void alloc() {
        User user = new User();
        user.setId(1L);
        user.setName("zhuge");
    }
}
