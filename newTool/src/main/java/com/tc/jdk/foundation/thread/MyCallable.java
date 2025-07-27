package com.tc.jdk.foundation.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public String call() {
        System.out.println("当前线程："+ Thread.currentThread().getName() + "。实现Callable");
        return "success";
    }
}
