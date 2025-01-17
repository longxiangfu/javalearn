package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.*;

/**
 * 实现限流
 */
public class SemaphoreDemo5 {
    // 限流器，同时只能处理5个请求
    private static final Semaphore semaphore = new Semaphore(5);
    private static final ExecutorService service = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(200));

    public static void main(String[] args) throws InterruptedException {
        for (;;) {
            Thread.sleep(100);
            // 模拟1s发出10个请求
            service.execute(() ->exec());
        }
    }

    private static void exec() {
        try {
            semaphore.acquire(1);
            System.out.println(Thread.currentThread().getName() + "执行exec方法");
            Thread.sleep(2000); // 模拟业务执行时间
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            semaphore.release(1);
        }
    }
}
