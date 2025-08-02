package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinPool演示
 * ForkjoinPool  ForkJoinTask
 * RecursiveTask  fork()    join()
 */
public class ForkJoinTestPool1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Long> future = forkJoinPool.submit(new Sum(1L, 10000000L));
        System.out.println(future.get());
    }

    /**
     * 计算和
     */
    private static class Sum extends RecursiveTask{
        // 每100个数分到一个线程来计算
        private static final Long THRESHOLD = 100L;
        private Long start;
        private Long end;

        public Sum(Long start, Long end){
            this.start = start;
            this.end = end;
        }

        @Override
        protected Object compute() {
            Long sum = 0L;
            if((end -start) < THRESHOLD){
                for (long i = start; i <= end; i++) {
                    sum += i;
                }
            }else {
                System.out.println("fork " + Thread.currentThread().getName());
                Long middle = (start + end) / 2;
                Sum leftSum = new Sum(start, middle);
                Sum rightSum = new Sum(middle + 1, end);
                leftSum.fork(); // fork(): 将当前任务提交到ForkJoinPool的任务队列中等待执行
                rightSum.fork();
                sum = (Long) leftSum.join() + (Long) rightSum.join(); // join()  完成后返回计算结果
            }
            return sum;
        }
    }
}
