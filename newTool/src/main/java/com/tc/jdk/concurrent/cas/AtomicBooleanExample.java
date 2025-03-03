package com.tc.jdk.concurrent.cas;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * CAS：可以保证线程安全，通过lock前缀指令和原子指令
 * AtomicBoolean
 * 这个例子展示了如何使用 AtomicBoolean 来确保对布尔值的修改是原子的，避免了多线程环境下的竞态条件。
 * @author longxiangfu
 */
public class AtomicBooleanExample {

	// 创建一个 AtomicBoolean 实例，初始值为 false
	private static final AtomicBoolean isRunning = new AtomicBoolean(false);

	public static void main(String[] args) {
		// 启动一个线程来设置标志位为 true
		Thread startThread = new Thread(() -> {
			if (isRunning.compareAndSet(false, true)) {
				System.out.println("System started.");
			} else {
				System.out.println("System is already running.");
			}
		});

		// 启动一个线程来尝试停止系统
		Thread stopThread = new Thread(() -> {
			if (isRunning.compareAndSet(true, false)) {
				System.out.println("System stopped.");
			} else {
				System.out.println("System is not running.");
			}
		});

		// 启动线程
		startThread.start();
		stopThread.start();

		// 等待线程完成
		try {
			startThread.join();
			stopThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


//	System started.
//	System stopped.
	


}
