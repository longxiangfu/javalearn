package com.tc.jdk.concurrent.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 使用阻塞队列解决生产者-消费者问题
 * @author longxiangfu
 *
 */
public class ProducerConsumerExample {
	
	public static void main(String[] args) throws InterruptedException {
        int numProducers = 1;
        int numConsumers = 1;

        BlockingQueue<Object> myQueue = new LinkedBlockingQueue<>(5);

        for (int i = 0; i < numProducers; i++) {
            new Thread(new Producer(myQueue)).start();
        }
        Thread.sleep(5000);
        for (int i = 0; i < numConsumers; i++) {
            new Thread(new Consumer(myQueue)).start();
        }

        Thread.sleep(10 * 1000);
        System.exit(0);
    }

}
