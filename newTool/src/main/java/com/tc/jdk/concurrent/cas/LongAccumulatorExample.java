package com.tc.jdk.concurrent.cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;

/**
 * LongAccumulator   try / catch
 * LongAdder功能的拓展
 */
public class LongAccumulatorExample {
    // 创建一个 LongAccumulator 实例
    private static final LongAccumulator accumulator;

    static {
        // 定义一个二元操作符，用于计算乘积
        LongBinaryOperator operator = (x, y) -> x + y;
        // 初始化 LongAccumulator，初始值为 0
        accumulator = new LongAccumulator(operator, 0);

    }

    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 提交多个任务来累积值
        for (int i = 0; i < 10; i++) {
            final int value = i + 1; // 从 1 到 10
            executorService.submit(() -> {
                for (int j = 0; j < 10; j++) {
                    accumulator.accumulate(value); // 累加值
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

        // 输出最终的累积值
        System.out.println("Final accumulated value: " + accumulator.get()); // Final accumulated value: 550
    }
}
