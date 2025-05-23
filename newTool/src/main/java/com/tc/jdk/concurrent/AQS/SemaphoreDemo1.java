package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.*;

/**
 * Semaphore信号量:控制访问资源的线程个数,即并发数
 * @author longxiangfu
 *
 */
public class SemaphoreDemo1 {
	private static final ExecutorService service = Executors.newCachedThreadPool();
	private static final Semaphore sp = new Semaphore(3);//总共有3个许可

	public static void main(String[] args) throws InterruptedException {
		for(int i = 0;i < 10;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Runnable runnabele = new Runnable() {
				@Override
				public void run() {
					try {
						sp.acquire();//获取许可,如果没有许可就等待
//						sp.tryAcquire(10, TimeUnit.SECONDS); // 试图获取信号量，有超时时间

						System.out.println("线程"+Thread.currentThread().getName()+
								"进入，当前已有"+(3-sp.availablePermits())+"并发");
						try {
							Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
						}catch(InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("线程"+Thread.currentThread().getName()+"即将离开");

					}catch(InterruptedException e) {
						e.printStackTrace();
					}finally {
						sp.release();//释放许可
					}

				}
				
			};
			service.execute(runnabele);
		}

		Thread.sleep(10000);
		service.shutdown();
	}

}
