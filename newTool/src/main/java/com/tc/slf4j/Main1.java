package com.tc.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

public class Main1 {
    private static final String KEY = "requestId";
    private static final Logger logger = LoggerFactory.getLogger(Main1.class);

    public static void main(String[] args) {
        // 入口传入请求id
        MDC.put(KEY, UUID.randomUUID().toString());

        logger.info("log in main thread 1");
        logger.info("log in main thread 2");
        logger.info("log in main thread 3");

        // 出口移除请求id
        MDC.remove(KEY);


//        2022-12-27 15:50:39.441 f9dcadef-76f4-478f-9a1d-c3a4461021c7 [main] INFO  com.tc.slf4j.Main1 Line:17  - log in main thread 1
//        2022-12-27 15:50:39.445 f9dcadef-76f4-478f-9a1d-c3a4461021c7 [main] INFO  com.tc.slf4j.Main1 Line:18  - log in main thread 2
//        2022-12-27 15:50:39.447 f9dcadef-76f4-478f-9a1d-c3a4461021c7 [main] INFO  com.tc.slf4j.Main1 Line:19  - log in main thread 3
    }


}
