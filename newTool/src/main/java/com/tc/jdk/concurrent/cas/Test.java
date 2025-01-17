package com.tc.jdk.concurrent.cas;

import javax.sound.sampled.FloatControl;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全示例
 */
public class Test {
    private volatile static int sum = 0;
    private static AtomicInteger sum1 = new AtomicInteger(0);
    private static ExecutorService service = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            50, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(20));

    static Object object = new Object();
    static ReentrantLock lock = new ReentrantLock();

    private static AtomicBoolean atomicBoolean = new AtomicBoolean(false);


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            service.submit(() ->{
                // 1 synchronized
//                synchronized (object) {
//
//                }

                // 2 lock
//                lock.lock();
//                try {
//                    for (int j = 0; j < 10000; j++) {
//                        // 当前线程把sum(10)从主内存读取到本地内存，之后操作后，再把sum(11)写回主内存时，不能保证现在主内存中sum是当前
//                        // 线程初始读取到的sum(10)
//                        sum++;
//                    }
//                    latch.countDown();
//                }catch (Exception e) {
//                    e.printStackTrace();
//                }finally {
//                    lock.unlock();
//                }

                // 3.1 cas  类似mysql乐观锁机制，用在读多写少的场景
                // 问题 1 自旋cas长时间不成功，消耗cpu ==》不能解决
                // 2 只能保证一个共享变量的原子操作 ==》不能解决
                // 3 ABA ==》AtomicStampedReference
//                for (;;) {
//                    if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
//                        try {
//                            for (int j = 0; j < 10000; j++) {
//                                sum++;
//                            }
//                            System.out.println("当前线程" + Thread.currentThread().getName() + "执行过后：" + sum);
//                        }finally {
//                            atomicBoolean.set(false);
//                        }
//                        break;
//                    }
//                }
                // 3.2 cas工具类--AtomicInteger
                for (int j = 0; j < 10000; j++) {
                    // AtomicInteger.incrementAndGet  原子操作，jvm底层是原子指令+ lock前缀指令，从而保证了线程安全
                    sum1.incrementAndGet();
                }

            });
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(sum);
        System.out.println(sum1.get());
        service.shutdownNow();
    }
}
