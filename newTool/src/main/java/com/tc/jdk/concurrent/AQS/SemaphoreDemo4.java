package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.*;

/**
 * 因为每次循序先执行release()，相当于加了一个信号量
 */
public class SemaphoreDemo4 {
    private static final Semaphore semaphore = new Semaphore(2);
    private static final CountDownLatch latch = new CountDownLatch(3);
    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors(), 60, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            executor.execute(() ->{
                semaphore.release();
                System.out.println("可用信号量：" + semaphore.availablePermits());
                try {
                    Thread.sleep(1000);
                    semaphore.acquire();
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("main");
        latch.await();
        executor.shutdown();
        System.out.println("main end");
//        main
//        可用信号量：3
//        可用信号量：5
//        可用信号量：4
//        main end
    }
}
