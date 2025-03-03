package com.tc.jdk.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger  AtomicLong  AtomicDouble
 * 这个例子展示了如何使用 AtomicInteger 来确保对整数值的修改是原子的，避免了多线程环境下的竞态条件。最终的计数值应该是 10000（10 个线程，每个线程增加 1000 次）。
 */
public class AtomicIntergerExample {

	// 创建一个 AtomicInteger 实例，初始值为 0
	private static final AtomicInteger counter = new AtomicInteger(0);
//	private static final AtomicLong counter1 = new AtomicLong(0);

	public static void main(String[] args) {
		// 创建多个线程来增加计数器的值
		Thread[] threads = new Thread[10];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					counter.incrementAndGet(); // 原子地增加计数器的值
				}
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

		// 输出最终的计数值
		System.out.println("Final counter value: " + counter.get()); // Final counter value: 10000
	}
		



}
