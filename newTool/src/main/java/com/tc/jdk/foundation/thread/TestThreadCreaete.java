package com.tc.jdk.foundation.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程创建的3种方式
 */
public class TestThreadCreaete {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();

        String result = new MyCallable().call();
        System.out.println(result);

    }
}
