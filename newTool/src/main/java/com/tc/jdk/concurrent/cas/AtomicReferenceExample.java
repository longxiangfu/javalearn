package com.tc.jdk.concurrent.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference    AtomicStampedReference    AtomicMarkableReference
 * 这个例子展示了如何使用 AtomicReference 来确保对引用类型的对象的修改是原子的，避免了多线程环境下的竞态条件。最终的 Person 对象引用将是最后一个线程设置的值。
 * 不保证引用的属性是线程安全的，如果需要保证引用的属性是线程安全的，则需要使用 AtomicReferenceFieldUpdater
 */
public class AtomicReferenceExample {

    // 创建一个 AtomicReference 实例，初始值为 null
    private static final AtomicReference<Person> personRef = new AtomicReference<>(null);

    public static void main(String[] args) {
        // 创建多个线程来更新 Person 对象的引用
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                Person newPerson = new Person("Person" + index);
                Person oldPerson = personRef.getAndSet(newPerson);
                System.out.println(Thread.currentThread().getName() + " set " + newPerson + ", old value was " + oldPerson);
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

        // 输出最终的 Person 对象引用
        System.out.println("Final Person reference: " + personRef.get());
    }

}
