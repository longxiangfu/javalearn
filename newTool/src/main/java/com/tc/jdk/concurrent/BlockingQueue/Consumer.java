package com.tc.jdk.concurrent.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private final BlockingQueue<Object> queue;

    Consumer(BlockingQueue<Object> theQueue) {
        this.queue = theQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object obj = queue.take();
                System.out.println("Consumed resource. Queue size now: "
                        + queue.size());
                take(obj);
            }
        } catch (InterruptedException ex) {
            System.out.println("CONSUMER INTERRUPTED");
        }
    }

    void take(Object obj) {
        try {
            Thread.sleep(1000); //模拟消费者拿到消息之后的工作
        } catch (InterruptedException ex) {
            System.out.println("Consumer Read INTERRUPTED");
        }
        System.out.println("Consuming object " + obj);
    }

}
