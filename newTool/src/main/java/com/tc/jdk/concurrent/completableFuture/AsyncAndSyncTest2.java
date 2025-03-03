package com.tc.jdk.concurrent.completableFuture;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * 同AsyncAndSyncTest
 * f.run   f.thenRun    f.complete     当前线程执行
 * f.runAsync    f.thenRunAsync     f.completeAsync  ForkJoinPool.commonPool中线程执行
 */
public class AsyncAndSyncTest2 {
    private static final CompletableFuture<Integer> f = new CompletableFuture<Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
//        test1();
//        test2();
//        test3();
        test4();
    }


    private static void test1() throws IOException, InterruptedException {
        f.runAsync(() -> {
            System.out.println("线程A：" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 当子线程A执行到f.complete的时候，会去看是否有注册好的f的then或者when（非async的），如果有的话，会顺次去执行。
            f.complete(100);//注意：如果将该语句删除，“线程B：main”将不会被打印
            System.out.println("线程A执行完成");
        });
        f.thenRun(() -> System.out.println("线程B：" + Thread.currentThread().getName()));
        System.out.println("线程C：" + Thread.currentThread().getName());
//        线程C：main
//        线程A：ForkJoinPool.commonPool-worker-1
//        线程B：ForkJoinPool.commonPool-worker-1
//        线程A执行完成
    }

    private static void test2() throws IOException, InterruptedException {
        CompletableFuture<Integer> f = new CompletableFuture<Integer>();
        f.runAsync(() -> {
            System.out.println("线程A：" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            f.complete(100);//注意：如果将该语句删除，“线程B：main”将不会被打印
            System.out.println("线程A执行完成");
        });
        TimeUnit.SECONDS.sleep(5);//主线程阻塞
        f.thenRun(() -> System.out.println("线程B：" + Thread.currentThread().getName()));
        System.out.println("线程C：" + Thread.currentThread().getName());
//        线程A：ForkJoinPool.commonPool-worker-1
//        线程A执行完成
//        线程B：main
//        线程C：main
    }


    private static void test3() throws IOException {
        CompletableFuture.runAsync(() ->{//内部相当于默认调用了CompletableFuture#complete
            System.out.println("线程A：" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程A执行完成");
        })
        .thenRun(() ->System.out.println("线程B：" + Thread.currentThread().getName()));
        System.out.println("线程C：" + Thread.currentThread().getName());
//        线程A：ForkJoinPool.commonPool-worker-1
//        线程C：main
//        线程A执行完成
//        线程B：ForkJoinPool.commonPool-worker-1
    }

    private static void test4() throws IOException {
        CompletableFuture.runAsync(() ->{
            System.out.println("线程A：" + Thread.currentThread().getName());
        })
                .thenRunAsync(() ->System.out.println("线程B：" + Thread.currentThread().getName()))
                .thenRunAsync(() ->System.out.println("线程C：" + Thread.currentThread().getName()))
                .thenRunAsync(() ->System.out.println("线程D：" + Thread.currentThread().getName()))
                .whenCompleteAsync((v,t) -> System.out.println("线程E：" + Thread.currentThread().getName()))
        ;

        // 因为都是异步的，所以打印出来的线程是随机的。
    }

}
