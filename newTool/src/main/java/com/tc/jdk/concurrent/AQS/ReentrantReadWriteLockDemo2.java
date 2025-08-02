package com.tc.jdk.concurrent.AQS;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁模拟一个线程安全的缓存器
 * 用在读多写少的场景，实现缓存器以保证线程安全
 * 读写锁：读的时候加读锁，这样其他线程也可以读；写的时候加写锁，其他线程不可以读写
 * 读写锁在同一时刻可以允许多个读线程访问，在写线程访问的时候其他的读线程和写线程都会被阻塞。读写锁维护一对锁(读锁和写锁)，通过锁的分离，使得并发性提高。
 * @author longxiangfu
 *
 */
public class ReentrantReadWriteLockDemo2 {
	private static Map<String, Object> map = new HashMap<String, Object>();//缓存器
	private static final ReadWriteLock rw = new ReentrantReadWriteLock();

	public static void main(String[] args) {
		Object value = null;
		rw.readLock().lock();//上读锁，从缓存中取
		try {
			value = map.get("a");
			if(null == value) {//如果缓存中没有值，则释放读锁，上写锁
				rw.readLock().unlock();
				rw.writeLock().lock();
				try {
					if(null == value) {
						value = "aaa";
					}
					/*
					 * 释放写锁之前，上读锁（锁允许降级，不允许升级，即writeLock允许降级为readLock，反之则不行）
					 * 必须是释放写锁之前获取读锁，主要是保证数据的可见性。如果直接释放写锁，那么在高并发场景下，
					 * 可能在获取读锁之前，已经有其他线程获取写锁并修改了数据，但是当前线程无法感知数据的变化
					 */
					rw.readLock().lock();
				}finally {
					rw.writeLock().unlock();
					
				}
			}
		}finally{
			rw.readLock().unlock();//释放读锁
		}
		
		System.out.println(value); // aaa
	}

}
