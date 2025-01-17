package com.tc.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2 {
    private static final String KEY = "requestId";
    private static final Logger logger = LoggerFactory.getLogger(Main2.class);
    private static final ExecutorService EXECUTORSERVICE = Executors.newWorkStealingPool();

    public static void main(String[] args) {
        // 入口传入请求id
        MDC.put(KEY, UUID.randomUUID().toString());

        // 主线程打印日志
        logger.info("log in main thread");

        // 异步线程打印日志
        new Thread(new MDCRunnable(new Runnable() {
            @Override
            public void run() {
                logger.info("log in other thread");
            }
        })).start();

        EXECUTORSERVICE.execute(new MDCRunnable(new Runnable() {
            @Override
            public void run() {
                logger.info("log in other thread pool");
            }
        }));
        EXECUTORSERVICE.shutdown();

        // 出口移除请求id
        MDC.remove(KEY);

//        2022-12-27 15:49:51.517 c6b611b3-2e98-4319-b75f-2a064f441344 [main] INFO  com.tc.slf4j.Main2 Line:21  - log in main thread
//        2022-12-27 15:49:51.526 c6b611b3-2e98-4319-b75f-2a064f441344 [Thread-0] INFO  com.tc.slf4j.Main2 Line:27  - log in other thread
//        2022-12-27 15:49:51.527 c6b611b3-2e98-4319-b75f-2a064f441344 [ForkJoinPool-1-worker-1] INFO  com.tc.slf4j.Main2 Line:34  - log in other thread pool
    }


}
