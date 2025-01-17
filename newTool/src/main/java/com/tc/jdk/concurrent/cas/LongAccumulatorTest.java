package com.tc.jdk.concurrent.cas;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

/**
 * LongAccumulator: 累加
 * LongAdder功能的拓展
 */
public class LongAccumulatorTest {
    private static ExecutorService executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            50, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));

    public static void main(String[] args) throws InterruptedException {
        LongAccumulator longAccumulator = new LongAccumulator((x,y) -> x + y, 0);
        IntStream.range(1, 10).forEach(i -> executorService.submit(() -> longAccumulator.accumulate(i)));
        Thread.sleep(2000);
        System.out.println(longAccumulator.getThenReset()); // 45
    }
}
