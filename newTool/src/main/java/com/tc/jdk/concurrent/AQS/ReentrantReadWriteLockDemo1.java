package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 演示读写锁
 * 读锁之间不互斥，写锁之间互斥
 * @author longxiangfu
 *
 */
public class ReentrantReadWriteLockDemo1 {

	public static void main(String[] args) {
//		readTest();
//		Thread-1 be ready to read data!
//				Thread-0 be ready to read data!
//				Thread-2 be ready to read data!
//				Thread-1 have read data:1000
//		Thread-0 have read data:1000
//		Thread-2 have read data:1000

//		writeTest();
//		Thread-0 be ready to write data!
//				Thread-0 have wrote data:3070
//		Thread-1 be ready to write data!
//				Thread-1 have wrote data:4278
//		Thread-2 be ready to write data!
//				Thread-2 have wrote data:2661
	}

	public static void readTest(){
		final Queue q = new Queue();
		for(int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					q.get();
				}
			}.start();
		}
	}

	public static void writeTest(){
		final Queue q = new Queue();
		for(int i = 0;i < 3; i++) {
			new Thread() {
				public void run() {
					q.put(ThreadLocalRandom.current().nextInt(10000));
				}
			}.start();
		}
	}


	static class Queue{
		private static Object data = 1000;//共享数据
		private static final ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

		public void get() {
			ReentrantReadWriteLock.ReadLock readLock = rw.readLock();
			try {
				readLock.lock();//上读锁，允许多个线程读取
				System.out.println(Thread.currentThread().getName()+" be ready to read data!");
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName()+" have read data:"+data);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}finally {
				readLock.unlock();//释放读锁
			}

		}

		public void put(Object data) {
			ReentrantReadWriteLock.WriteLock writeLock = rw.writeLock();
			try {
				writeLock.lock();//上写锁，只允许一个线程写
				System.out.println(Thread.currentThread().getName()+" be ready to write data!");
				Thread.sleep(2000);
				this.data = data;
				System.out.println(Thread.currentThread().getName()+" have wrote data:"+data);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}finally {
				writeLock.unlock();//释放写锁
			}
		}


	}
	

}
