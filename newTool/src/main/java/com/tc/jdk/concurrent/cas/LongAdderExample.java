package com.tc.jdk.concurrent.cas;

import java.util.concurrent.*;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

/**
 * LongAdder   DoubleAdder
 * 原子操作，效率比AtomicLong等都要高
 * 这个例子展示了如何使用 LongAdder 来确保对计数器的修改是原子的，并且在高并发环境下具有更好的性能。最终的计数值应该是 100000（100 个任务，每个任务增加 1000 次）。
 */
public class LongAdderExample {
    // 创建一个 LongAdder 实例
    private static final LongAdder counter = new LongAdder();
    LongAdder adder = new LongAdder();

    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
//                200, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));


        // 提交多个任务来增加计数器的值
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment(); // 原子地增加计数器的值
                }
            });
        }

        // 关闭线程池并等待所有任务完成
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出最终的计数值
        System.out.println("Final counter value: " + counter.sum());
    }
}
