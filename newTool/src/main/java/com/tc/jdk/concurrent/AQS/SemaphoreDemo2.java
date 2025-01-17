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
	private static final Bussiness bussiness = new Bussiness();
	private static ExecutorService executor = Executors.newFixedThreadPool(3);
	private static CountDownLatch latch = new CountDownLatch(3);

	public static void main(String[] args) throws InterruptedException {
		for(int i = 0;i < 3;i++) {
			executor.execute(
					new Runnable() {
						@Override
						public void run()
						{
							bussiness.service();
							latch.countDown();
						}
					}
					);
		}
		latch.await();
		executor.shutdown();
	}
	
	private static class Bussiness {
		private int count;
		Semaphore sp = new Semaphore(1);
		
		public void service() {
			try {
				sp.acquire();//当线程使用count变量的时候将count锁住，不允许其他线程访问
				count++;
				Thread.sleep(1000);
				System.out.println(count);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				sp.release();//释放锁
			}
			
		}
	}

}
