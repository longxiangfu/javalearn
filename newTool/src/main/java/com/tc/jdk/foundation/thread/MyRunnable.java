package com.tc.jdk.foundation.thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("当前线程："+ Thread.currentThread().getName() + "。实现Runnable");
    }
}
