package com.tc.jdk.concurrent.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	private final BlockingQueue<Object> queue;

    Producer(BlockingQueue<Object> theQueue) {
        this.queue = theQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object justProduced = getResource();
                queue.put(justProduced);
                System.out.println("Produced resource. Queue size now: "
                        + queue.size());
            }
        } catch (InterruptedException ex) {
            System.out.println("Producer INTERRUPTED");
        }
    }

    Object getResource() {
        try {
            Thread.sleep(500); //模拟生产者准备消息时间
        } catch (InterruptedException ex) {
            System.out.println("Producer Read INTERRUPTED");
        }
        return new Object();
    }

}
