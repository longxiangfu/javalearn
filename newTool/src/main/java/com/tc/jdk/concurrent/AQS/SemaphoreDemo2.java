package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore：也可实现互斥锁（当只有一个许可时），同ReenterantLock
 * @author longxiangfu
 *
 */
public class SemaphoreDemo2 {
	private static volatile int count;
	private static final Semaphore sp = new Semaphore(1); // 相当于互斥锁
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				try {
					sp.acquire();//当线程使用count变量的时候将count锁住，不允许其他线程访问
					System.out.println(Thread.currentThread().getName() + "获取到许可");
					count++;
					Thread.sleep(1000);
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					sp.release();//释放锁
					System.out.println(Thread.currentThread().getName() + "释放许可");
				}
			}).start();
		}


//		Thread-0获取到许可
//		Thread-0释放许可
//		Thread-1获取到许可
//		Thread-1释放许可
//		Thread-2获取到许可
//		Thread-2释放许可
//		Thread-3获取到许可
//		Thread-3释放许可
//		Thread-4获取到许可
//		Thread-4释放许可

	}

}
