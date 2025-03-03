package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo3 {
	private static final CyclicBarrier c = new CyclicBarrier(3);

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();   
                } catch (Exception e) {
                }
            }
        });
        thread.start();

		Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
            }
        });
        thread1.start();

        Thread.sleep(2000);
        System.out.println("barrier是否阻塞：" + c.isBroken());   // false   是否有线程被中断
        System.out.println("barrier阻塞的线程数：" + c.getNumberWaiting());   // 2   正在barrier阻塞的线程数

        try {
            // 线程是否有中断
            System.out.println("a");
            thread.interrupt();
            System.out.println("b");
            c.await();
            System.out.println("c");
        } catch (Exception e) {
            System.out.println("barrier是否阻塞1：" + c.isBroken());   // true   有线程被中断
            System.out.println("barrier阻塞的线程数1：" + c.getNumberWaiting());   // 0   正在barrier阻塞的线程数
        }

//        barrier是否阻塞：false
//        barrier阻塞的线程数：2
//        a
//        b
//        barrier是否阻塞1：true
//        barrier阻塞的线程数1：0

	}

}
