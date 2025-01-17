package com.tc.jdk.concurrent.completableFuture;

import org.assertj.core.api.ThrowableAssert;

import java.io.IOException;
import java.util.concurrent.*;


/**
 * 演示jdk8中并发包下的CompletableFuture
 * 说明：之前异步Future只能阻塞等待结果；而现在CompletableFuture异步执行之后，会掉另外的任务，非常棒
 * 异步回调和声明式
 * 不以Async结尾的方法也可能是非阻塞的，只是由JVM根据结果是否已经就绪来确定是继续在之前的线程执行还是分配到新的线程（见AsyncAndSyncTest和AsyncAndSyncTest1）
 * 任务编排
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
//        start();
        next();
    }


    /**
     * 提交任务执行
     */
    public static void start() throws IOException, ExecutionException, InterruptedException {
        /*
        runAsync(Runnable): 提交执行无返回值的任务，默认执行线程是ForkJoinPool#commonPool()
        runAsync(Runnable, Executor):提交执行无返回值的任务，指定Executor执行
         */
//        CompletableFuture.runAsync(() ->{
//            System.out.println("位置a:" + Thread.currentThread().getName());
//            System.out.println("位置a:" + "runAsync " + Thread.currentThread().getName());
//        });
//        System.out.println("位置b:" + Thread.currentThread().getName());
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        CompletableFuture.runAsync(() ->{
//            System.out.println("位置c:" + Thread.currentThread().getName());
//            System.out.println("位置c:" + "runAsync " + Thread.currentThread().getName());
//        }, executorService);
//        System.out.println("位置b:" + Thread.currentThread().getName());
//        位置b:main
//        位置a:ForkJoinPool.commonPool-worker-1
//        位置a:runAsync ForkJoinPool.commonPool-worker-1
//        位置c:pool-1-thread-1
//        位置c:runAsync pool-1-thread-1
//        位置b:main


        /*
        supplyAsync(Runnable):提交有返回值的任务，默认的线程是ForkJoinPool#commonPool()
        supplyAsync(Runnable, Executor)：提交有返回值的任务，指定Executor执行
         */
//        CompletableFuture.supplyAsync(() ->{
//            System.out.println("supplyAsync " + Thread.currentThread().getName());
//            return 1;
//        });
//        System.in.read();
//        supplyAsync ForkJoinPool.commonPool-worker-1


        /*
        allOf：给定的所有的CompletableFuture都完成后，才完成
        anyOf:给定的任何一个CompletableFuture完成，就完成
         */
//        CompletableFuture<Void> future = CompletableFuture.allOf(
//                CompletableFuture.runAsync(() -> {
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("allOf1");
//                }),
//                CompletableFuture.runAsync(() -> {
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("allOf2");
//                })
//        );
//        System.out.println("阻塞 " + Thread.currentThread().getName());
//        future.join();
//        System.out.println("阻塞结束 " + Thread.currentThread().getName());
//        阻塞 main
//        allOf1
//        allOf2
//        阻塞结束 main

//        CompletableFuture<Object> future1 = CompletableFuture.anyOf(
//                CompletableFuture.runAsync(() -> {
//                    try {
//                        Thread.sleep(3000);
//                        System.out.println("anyOf1");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }),
//                CompletableFuture.runAsync(() -> {
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("anyOf2");
//                })
//        );
//        System.out.println("阻塞 " + Thread.currentThread().getName());
//        Object join = future1.join();
//        System.out.println(join.toString());
//        System.out.println("阻塞结束 " + Thread.currentThread().getName());
//        阻塞 main
//        anyOf1
//        阻塞结束 main


        CompletableFuture<Integer> completedFuture = CompletableFuture.completedFuture(1000);
        CompletableFuture<Integer> completedFuture1 = CompletableFuture.completedFuture(null);
        System.out.println(completedFuture.get()); // 1000
        System.out.println(completedFuture1.get()); // null

    }


    /**
     * 执行下一阶段
     */
    public static void next() throws ExecutionException, InterruptedException {
        /*
        thenRunAsync：不处理上阶段返回值，该阶段无返回值。
         */
//        CompletableFuture.runAsync(() ->{
//            System.out.println("步骤1。线程：" + Thread.currentThread().getName()); // 步骤1。线程：ForkJoinPool.commonPool-worker-1
//        }).thenRunAsync(() ->{
//            System.out.println("步骤2。线程：" + Thread.currentThread().getName()); // 步骤2。线程：ForkJoinPool.commonPool-worker-1
//        });

        /*
        thenAccept:处理上阶段返回值，该阶段无返回值。
         */
//        CompletableFuture.supplyAsync(() ->{
//            System.out.println("步骤1。线程：" + Thread.currentThread().getName()); // 步骤1。线程：ForkJoinPool.commonPool-worker-1
//            return 1;
//        }).thenAcceptAsync(beforeResult->{
//            System.out.println("步骤2。上阶段结果为：" + beforeResult); // 步骤2。上阶段结果为：1
//            System.out.println("线程："  + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-1
//        });


        /*
        thenApplyAsync：处理上阶段返回值，该阶段有返回值。
         */
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
//            System.out.println("步骤1。线程：" + Thread.currentThread().getName()); // 步骤1。线程：ForkJoinPool.commonPool-worker-1
//            return 1;
//        }).thenApplyAsync(beforeResult -> {
//            System.out.println("步骤2。上阶段结果为：" + beforeResult); // 步骤2。上阶段结果为：1
//            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-1
//            return 2;
//        });
//        System.out.println(completableFuture.get()); // 2


        /*
        thenCombine:合并两个任务的结果，有返回值。
         */
        CompletableFuture<Integer> completableFuture =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-1
                    return 6;
                }).thenCombineAsync(
                        CompletableFuture.supplyAsync(() -> {
                            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-1
                            return 10;
                        }),
                        (one, two) -> {
                            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-2
                            return one + two;
                }).thenCombineAsync(
                        CompletableFuture.supplyAsync(() -> {
                            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-2
                            return 10;
                        }),
                        (one, two) -> {
                            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-2
                            return one + two;
                        }
                );
        System.out.println(completableFuture.get()); // 26


        /*
        thenAcceptBothAsync:合并两个任务的结果，无返回值。
         */
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-1
//            return 1;
//        }).thenAcceptBothAsync(
//                CompletableFuture.supplyAsync(() -> {
//                    System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-1
//                    return 2;
//                }),
//                (one, two) -> {
//                    System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-2
//                    System.out.println(one + two); // 3
//                }
//        );

        /*
        runAfterBoth: 两个任务都执行完后，调用指定的操作
         */
//        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("第一阶段。线程：" + Thread.currentThread().getName()); // 第一阶段。线程：ForkJoinPool.commonPool-worker-1
//            return 6;
//        }).runAfterBothAsync(
//                CompletableFuture.runAsync(() -> System.out.println("第二阶段：线程：" + Thread.currentThread().getName())), // 第二阶段：线程：ForkJoinPool.commonPool-worker-1
//                () -> System.out.println("前面两个阶段都执行完成后执行该任务。线程：" + Thread.currentThread().getName()) // 前面两个阶段都执行完成后执行该任务。线程：ForkJoinPool.commonPool-worker-1
//        );
//        System.out.println(future.join()); // null


        /*
        runAfterEither:两个任务任何一个正常完成后，调用指定的操作
         */
//        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("第一阶段。线程：" + Thread.currentThread().getName());
//            return 1;
//        }).runAfterEitherAsync(
//                CompletableFuture.runAsync(() -> {
//                    System.out.println("第二阶段。线程：" + Thread.currentThread().getName()); // 第二阶段。线程：ForkJoinPool.commonPool-worker-2
//                }),
//                () -> {
//                    System.out.println("两个阶段任何一个正常完成后，调用该操作。线程：" + Thread.currentThread().getName()); // 两个阶段任何一个正常完成后，调用该操作。线程：ForkJoinPool.commonPool-worker-2
//                }
//        );
//        future.join();


        /*
        whenComplete:当上阶段完成后，将上阶段的结果以及上阶段的异常作为参数执行后续的操作
         */
//        CompletableFuture.supplyAsync(() ->{
//            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-1
//            throw new RuntimeException();
////            return 1;
//        }).whenCompleteAsync((beforeResult, throwable) -> {
//            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-1
//            System.out.println("上阶段结果：" + beforeResult); // 上阶段结果：null
//            System.out.println("上阶段异常：" + throwable); // 上阶段异常：java.util.concurrent.CompletionException: java.lang.RuntimeException
//        });


        /*
        whenCompose:当上阶段正常完成后，将上阶段的结果作为提供函数的参数执行函数
         */
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-1
//            return 1;
//        }).thenComposeAsync((beforeResult) -> {
//            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-1
//            return CompletableFuture.completedFuture(beforeResult);
//        });
//        System.out.println(future.get()); // 1


        /*
        handle:当上阶段完成后，将上阶段的结果以及阶段的异常作为参数执行后续的操作
         */
//        CompletableFuture<Integer> completableFuture = CompletableFuture
//                .supplyAsync(() -> 1)
//                .handleAsync((r, throwable) -> r + 3);
//        System.out.println(completableFuture.join()); // 4

    }
}
