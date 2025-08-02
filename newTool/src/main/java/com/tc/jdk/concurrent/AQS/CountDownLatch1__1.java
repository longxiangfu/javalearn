package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示:CountDownLatch
 * 1对多；任务拆分后交由多线程来执行
 *
 */
public class CountDownLatch1__1 {
	private static final CountDownLatch countDownLatch = new CountDownLatch(5);
	private static volatile int sum = 0;
	private static final ExecutorService service = Executors.newFixedThreadPool(5);
	
	public static void main(String[] args) throws InterruptedException {
		for (AtomicInteger i = new AtomicInteger(0); i.get() < 5; i.getAndIncrement()) {
			service.execute(() -> {
				System.out.println("线程：" + Thread.currentThread().getName());
				int num = i.getAndIncrement();
				for (int j = (num-1)*200; j < num*200; j++) {
					sum += j;
				}
				countDownLatch.countDown();
			});
		}

		countDownLatch.await();
		System.out.println("sum:"+sum);
		service.shutdown();
	}


}
