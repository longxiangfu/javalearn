package com.tc.jdk.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * AtomicIntegerFieldUpdater
 * AtomicReferenceFieldUpdater
 */
public class Cas4 {

    public static class Candidate {
        volatile int score = 0;
        AtomicInteger score2 = new AtomicInteger();
        volatile Integer score3 = 0;
    }
    // 对应的属性必须是int或long，不能是对应的包装类型Integer或Long
    public static final AtomicIntegerFieldUpdater scoreUpdater = AtomicIntegerFieldUpdater
            .newUpdater(Candidate.class, "score");
    public static AtomicInteger realScore = new AtomicInteger(0);
    // 对应的属性是包装类型
    public static AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = AtomicReferenceFieldUpdater
            .newUpdater(Candidate.class, Integer.class, "score3");

    public static void main(String[] args) throws InterruptedException {
        final Candidate candidate = new Candidate();
        Thread[] t = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            t[i] = new Thread(() -> {
                if (Math.random() > 0.4) {
                    candidate.score2.incrementAndGet();
                    scoreUpdater.incrementAndGet(candidate);
                    realScore.incrementAndGet();
                }
            });
            t[i].start();
        }

        for (int i = 0; i < 10000; i++) {
            t[i].join();
        }

        System.out.println("AtomicIntegerFieldUpdater score:" + candidate.score);
        System.out.println("AtomicInteger score:" + candidate.score2.get());
        System.out.println("realScore:" + realScore.get());
    }
}
