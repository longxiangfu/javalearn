package com.tc.jdk.foundation.thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("当前线程："+ Thread.currentThread().getName() + "。继承Thread");
    }
}
