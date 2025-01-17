package com.tc.slf4j;

import org.slf4j.MDC;

import java.util.*;

public class MDCRunnable implements Runnable {

    private final Runnable runnable;

    private final Map<String, String> map;

    public MDCRunnable(Runnable runnable) {
        this.runnable = runnable;
        this.map = MDC.getCopyOfContextMap();
    }


    @Override
    public void run() {
        // 将主线程传入的值放入子线程的MDC中
        for (Map.Entry<String, String> entry:
             map.entrySet()) {
            MDC.put(entry.getKey(), entry.getValue());
        }

        // 装饰器模式，执行run方法
        this.runnable.run();

        // 清除子线程的MDC
        for (Map.Entry<String, String> entry:
                map.entrySet()) {
            MDC.remove(entry.getKey());
        }
        
    }
}
