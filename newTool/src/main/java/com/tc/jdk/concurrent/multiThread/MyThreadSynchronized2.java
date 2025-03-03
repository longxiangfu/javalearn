package com.tc.jdk.concurrent.multiThread;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 *
 */
public class MyThreadSynchronized2 {

	public static void main(String[] args) throws InterruptedException {
//		Object o = new Object();
//		System.out.println(ClassLayout.parseInstance(o).toPrintable());
//
//		synchronized (o) {
//			System.out.println(ClassLayout.parseInstance(o).toPrintable());
//		}


		Object o = new Object();
		System.out.println(ClassLayout.parseInstance(o).toPrintable());
		// 经测试，2秒后，对象会自动加偏向锁，1s不会加偏向锁
		Thread.sleep(2000);
		Object o2 = new Object();
		System.out.println(ClassLayout.parseInstance(o2).toPrintable());


	}

}
