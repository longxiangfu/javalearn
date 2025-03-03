package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基础操作
 * 重入锁相比synchonized:
 * 1、等待可中断：tryLock(long time, TimeUnit unit)、lockInterruptibly()
 * 2、可以创建公平锁（他们默认创建的都是非公平锁，不过非公平锁效率高）:构造函数boolean设置为true,ReentrantLock(boolean fair)
 * @author 15652
 *
 */
public class MyThreadReentrantLock implements Runnable{
	
	private static final ReentrantLock lock = new ReentrantLock(); // 非公平锁
//	private static final ReentrantLock lock1 = new ReentrantLock(true);//公平锁
	@Override
	public void run() {
//		lock.lock(); // 获取不到锁就阻塞
//		lock.tryLock(); // 获取不到锁就返回false
//
//		try {
		// // 获取不到锁就返回false,有超时时间
//			lock.tryLock(3, TimeUnit.SECONDS);//获取锁期间，若线程被中断，则抛出InterruptedException
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		try {
		// 获取不到就阻塞，可以被中断
//			lock.lockInterruptibly();//获取锁期间，若线程被中断，则抛出InterruptefException
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		try {
//			for(int i = 0;i < 5;i++) {
//				System.out.println(Thread.currentThread().getName()+":"+i);
//			}
//		}finally {
//			//解锁
//			lock.unlock();
//		}
		
	}
	

}
