package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier.CyclicBarrier(int parties, Runnable barrierAction)
 * 当所有线程到达屏障时，优先执行barrierAction任务
 * @author longxiangfu
 *
 */
public class CyclicBarrierDemo2 {
	private static final CyclicBarrier barrier = new CyclicBarrier(2, ()->{
		System.out.println("所有线程到达CyclicBarrier后执行任务");
	});

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName() + "到达");
					barrier.await();
				}catch(Exception e) {
					//
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() + "到达");
					barrier.await();
				}catch(Exception e) {
					//
				}
			}
		});

		t1.start();
		t2.start();

		System.out.println("mian等待");
		t1.join();
		t2.join();
		System.out.println("mian执行完成");

//		mian等待
//		Thread-1到达
//		Thread-2到达
//		所有线程到达CyclicBarrier后执行任务
//		mian执行完成

	}

}
