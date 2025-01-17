package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo3 {
	private static final CyclicBarrier c = new CyclicBarrier(2);

	public static void main(String[] args) {
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

        // 线程是否有中断
        thread.interrupt();
        try {
            c.await();  
        } catch (Exception e) {
            System.out.println(c.isBroken());   // true
        }


        // 发生异常时，可重置（CountDownLatch不能重置）
        try {
        	throw new Exception("我抛出一个 错误！");
        }catch(Exception e) {
        	e.printStackTrace();
        	c.reset();
        	System.out.println(c.getParties()); // 2
        }

        // 返回阻塞的线程数
        c.getNumberWaiting();
        // 阻塞的线程是否被中断
        c.isBroken();

	}

}
