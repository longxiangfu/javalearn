package com.tc.jdk.concurrent.completableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture<Integer> f = new CompletableFuture<Integer>();
 * f.complete 和 f.whenComplete
 *
 * 参照：https://blog.csdn.net/leon_wzm/article/details/80560081
 */
public class AsyncAndSyncTest {

    private static final Logger logger = LoggerFactory.getLogger(AsyncAndSyncTest.class);


    public static void main(String[] args) throws IOException {
//        test1();
        test2();
    }

    private static void test1() throws IOException {
        CompletableFuture<Integer> f = new CompletableFuture<Integer>();

        new Thread(() -> {
            // 子线程A启动
            logger.info("子线程A启动 " + Thread.currentThread().getName());
            try {
                logger.info("子线程A沉睡5s " + Thread.currentThread().getName());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("子线程A令future完成 " + Thread.currentThread().getName());
            f.complete(100);  // 当子线程A执行到f.complete的时候，会去看是否有注册好的f的then或者when（非async的），如果有的话，会顺次去执行。
            logger.info("子线程A结束 " + Thread.currentThread().getName());
        }).start();


        // 当前线程（主线程）执行到这里的时候，如果子线程还没有执行到f.complete(100)，
        // 那么当前线程会把whenComplete事件注册起来，并且说好如果哪个线程执行了f.complete(100)，
        // 哪个线程就负责执行whenComplete的内容。
        // 如果当前线程（主线程）执行到这里的时候，f.complete(100)已经被其他线程执行完毕了。
        // 那么只有当前线程（主线程）自己来执行whenComplete里面的内容了。
        f.whenComplete((i, ex) -> {
            // 这个场景下，whenComplete的回调的执行线程会是子线程A
            logger.info("do something after complete begin "  + Thread.currentThread().getName());
            try {
                logger.info("沉睡10s "  + Thread.currentThread().getName());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("do something after complete end " + Thread.currentThread().getName());
        });

        logger.info("main over " + Thread.currentThread().getName());
//        2023-05-12 14:13:38.383  [main] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:63  - main over main
//        2023-05-12 14:13:38.383  [Thread-0] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:33  - 子线程A启动 Thread-0
//        2023-05-12 14:13:38.393  [Thread-0] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:35  - 子线程A沉睡5s Thread-0
//        2023-05-12 14:13:43.393  [Thread-0] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:40  - 子线程A令future完成 Thread-0
//        2023-05-12 14:13:43.393  [Thread-0] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:53  - do something after complete begin Thread-0
//        2023-05-12 14:13:43.394  [Thread-0] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:55  - 沉睡10s Thread-0
//        2023-05-12 14:13:53.395  [Thread-0] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:60  - do something after complete end Thread-0
//        2023-05-12 14:13:53.395  [Thread-0] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:42  - 子线程A结束 Thread-0
    }

    private static void test2() throws IOException {
        CompletableFuture<Integer> f = new CompletableFuture<Integer>();

        new Thread(() -> {
            // 子线程A启动
            logger.info("子线程A启动 " + Thread.currentThread().getName());
            try {
                logger.info("子线程A沉睡5s " + Thread.currentThread().getName());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("子线程A令future完成 " + Thread.currentThread().getName());
            f.complete(100);  // 当子线程A执行到f.complete的时候，会去看是否有注册好的f的then或者when（非async的），如果有的话，会顺次去执行。
            logger.info("子线程A结束 " + Thread.currentThread().getName());
        }).start();

        try {
            logger.info("主线程沉睡10s " + Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        f.whenComplete((i, ex) -> {
            // 这个场景下，whenComplete的回调的执行线程会是主线程
            logger.info("do something after complete begin " + Thread.currentThread().getName());
            try {
                logger.info("沉睡10s " + Thread.currentThread().getName());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            logger.info("do something after complete end " + Thread.currentThread().getName());
        });


        logger.info("main over " + Thread.currentThread().getName());
//        2023-05-12 14:21:13.094  [Thread-0] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:80  - 子线程A启动 Thread-0
//        2023-05-12 14:21:13.095  [main] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:93  - 主线程沉睡10s main
//        2023-05-12 14:21:13.099  [Thread-0] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:82  - 子线程A沉睡5s Thread-0
//        2023-05-12 14:21:18.100  [Thread-0] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:87  - 子线程A令future完成 Thread-0
//        2023-05-12 14:21:18.100  [Thread-0] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:89  - 子线程A结束 Thread-0
//        2023-05-12 14:21:23.102  [main] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:100 - do something after complete begin main
//        2023-05-12 14:21:23.103  [main] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:102 - 沉睡10s main
//        2023-05-12 14:21:33.103  [main] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:108 - do something after complete end main
//        2023-05-12 14:21:33.103  [main] INFO  com.tc.jdk.concurrent.completableFuture.AsyncAndSyncTest Line:112 - main over main

    }
}
