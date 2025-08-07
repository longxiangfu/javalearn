package com.tc.jdk.collectionDemo.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue
 * 1、在初始化时必须指定容量，且容量不可修改。有界队列
 * 2、存在公平访问和非公平访问
 * 3、线程安全的（ReenterLock）
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(6);
        ArrayBlockingQueue<Integer> arrayBlockingQueue1 = new ArrayBlockingQueue<>(6, true);
//        arrayBlockingQueue1.add(null);//会报空指针异常
//        arrayBlockingQueue.add(null);//会报空指针异常

        arrayBlockingQueue.add("a");
        System.out.println("剩余容量：" + arrayBlockingQueue.remainingCapacity());
        arrayBlockingQueue.add("b");
        arrayBlockingQueue.add("c");
        arrayBlockingQueue.add("d");
        arrayBlockingQueue.add("e");
        arrayBlockingQueue.add("f");
        arrayBlockingQueue.add("g"); // 报错：Queue full
    }
}
