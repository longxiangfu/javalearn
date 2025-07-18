package com.tc.jdk.foundation.sourceShouXie.messageQueue;

import java.util.concurrent.ArrayBlockingQueue;

/***
 * 手动实现消息队列
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        // 启动1个消费者线程
        test.new Consumer().start();
        // 启动10个生产者线程
        for (int i = 0; i < 10; i++) {
            test.new Producer().start();
        }
    }

    // 队列的最大长度
    private int queueSize = 10;

    // 定义队列
    ArrayBlockingQueue queue = new ArrayBlockingQueue<Integer>(queueSize);

    // 生产者
    class Producer extends Thread{
        @Override
        public void run() {
            // 生产消息的时候加锁
            synchronized (queue) {
                if (queue.size() < queueSize) {
                    // 队列未满，则添加消息
                    int msg = queue.size()+1;
                    queue.add(msg);
                    System.out.println("生产了1个消息:" + msg + "，队列长度:" + queue.size());
                    // 唤醒所有等待的线程，这里唤醒的是消费者等待线程
                    queue.notifyAll();
                    // 模拟业务处理
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else {
                    // 队列满了，则等待，释放锁
                    try {
                        System.out.println("生产时，队列已满，等待...");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        queue.notifyAll();
                    }
                }
            }
        }
    }

    // 消费者
    class Consumer extends Thread{
        @Override
        public void run() {
            // 不停地消费消息
            while (true) {
                // 消费消息的时候加锁
                synchronized (queue) {
                    if (queue.isEmpty()) {
                        // 队列为空，则等待，释放锁
                        try {
                            System.out.println("消费时，队列为空，等待...");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notifyAll();
                        }
                    }
                    else {
                        // 消费消息
                        int msg = (int)queue.poll();
                        System.out.println("消费了1个消息:" + msg + "，队列长度:" + queue.size());
                        // 唤醒所有等待的线程，这里唤醒的是生产者等待线程
                        queue.notifyAll();
                        // 模拟业务处理
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
