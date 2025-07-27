package com.tc.jdk.jdk_E.completable;

import java.util.concurrent.*;


/**
 * 演示jdk8中并发包下的CompletableFuture
 * 说明：之前异步Future只能阻塞等待结果；而现在CompletableFuture异步执行之后，会掉另外的任务，非常棒
 * 异步回调和声明式
 * 不以Async结尾的方法也可能是非阻塞的，只是由JVM根据结果是否已经就绪来确定是继续在之前的线程执行还是分配到新的线程（见AsyncAndSyncTest和AsyncAndSyncTest1）
 * 任务编排
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        start();
        next();
    }


    /**
     * 提交任务
     * runAsync(Runnable): 提交执行无返回值的任务，默认执行线程是ForkJoinPool#commonPool()
     * runAsync(Runnable, Executor):提交执行无返回值的任务，指定Executor执行
     *
     * supplyAsync(Runnable):提交有返回值的任务，默认的线程是ForkJoinPool#commonPool()
     * supplyAsync(Runnable, Executor)：提交有返回值的任务，指定Executor执行
     *
     * allOf：给定的所有的CompletableFuture都完成后，才完成。
     * anyOf:给定的任何一个CompletableFuture完成，就完成。
     *
     * completedFuture  返回一个已经完成的CompletableFuture
     */
    public static void start() throws ExecutionException, InterruptedException {
        //runAsync(Runnable): 提交执行无返回值的任务，默认执行线程是ForkJoinPool#commonPool()
        // runAsync(Runnable, Executor):提交执行无返回值的任务，指定Executor执行
//        CompletableFuture.runAsync(() ->{
//            System.out.println(Thread.currentThread().getName()); // ForkJoinPool.commonPool-worker-25
//            System.out.println("runAsync"); // runAsync
//        });
//        System.out.println(Thread.currentThread().getName()); // main
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        CompletableFuture.runAsync(() ->{
//            System.out.println(Thread.currentThread().getName()); // pool-1-thread-1
//            System.out.println("runAsync");
//        }, executorService);
//        // 关闭线程池，否则进程不会停止
//        executorService.shutdown();


        //supplyAsync(Runnable):提交有返回值的任务，默认的线程是ForkJoinPool#commonPool()
        //supplyAsync(Runnable, Executor)：提交有返回值的任务，指定Executor执行
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("supplyAsync"); // supplyAsync
//            return 1;
//        });
//        System.out.println(future.get()); // 1


        //allOf：给定的所有的CompletableFuture都完成后，才完成。
        //anyOf:给定的任何一个CompletableFuture完成，就完成。
//        CompletableFuture future = CompletableFuture.allOf(
//                CompletableFuture.runAsync(() -> {
//                    System.out.println("allOf1开始");
//                    try {
//                        Thread.sleep(2000);
//                        System.out.println("allOf1结束");
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }),
//                CompletableFuture.runAsync(() -> {
//                    System.out.println("allOf2开始");
//                    try {
//                        Thread.sleep(5000);
//                        System.out.println("allOf2结束");
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                })
//        );
//        System.out.println(future.get());

//        CompletableFuture<Object> future = CompletableFuture.anyOf(
//                CompletableFuture.supplyAsync(() -> {
//                    System.out.println("allOf1开始");
//                    try {
//                        Thread.sleep(2000);
//                        System.out.println("allOf1结束");
//                        return 1;
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }),
//                CompletableFuture.runAsync(() -> {
//                    System.out.println("allOf2开始");
//                    try {
//                        Thread.sleep(5000);
//                        System.out.println("allOf2结束");
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                })
//        );
//        System.out.println(future.get()); // 1    allOf1先完成


        // completedFuture  返回一个已经完成的CompletableFuture
        CompletableFuture<Integer> completedFuture = CompletableFuture.completedFuture(1000);
        CompletableFuture<Integer> completedFuture1 = CompletableFuture.completedFuture(null);
        System.out.println(completedFuture.get());
        System.out.println(completedFuture1.get());



    }


    /**
     * 执行下一阶段任务
     * thenRunAsync：不处理上阶段返回值，该阶段无返回值。
     * thenAcceptAsync:处理上阶段返回值，该阶段无返回值。
     * thenApplyAsync：处理上阶段返回值，该阶段有返回值。
     *
     * thenCombineAsync:合并两个任务的结果，有返回值。
     * thenAcceptBothAsync:合并两个任务的结果，无返回值。
     *
     * runAfterBoth: 两个任务执行完后，调用指定的操作
     * runAfterEither:两个任务任何一个正常完成后，调用指定的操作
     *
     * whenComplete:当阶段完成后，将阶段的结果以及阶段的异常作为参数执行后续的操作
     * whenCompose:当阶段正常完成后，该阶段的结果作为提供函数的参数执行函数
     */
    public static void next() throws ExecutionException, InterruptedException {
        //thenRunAsync：不处理上阶段返回值，该阶段无返回值。
//        CompletableFuture.runAsync(() ->{
//            System.out.println("步骤1。线程：" + Thread.currentThread().getName()); // 步骤1。线程：ForkJoinPool.commonPool-worker-25
//        }).thenRunAsync(() ->{
//            System.out.println("步骤2。线程：" + Thread.currentThread().getName()); // 步骤2。线程：ForkJoinPool.commonPool-worker-25
//        });

        //thenAcceptAsync:处理上阶段返回值，该阶段无返回值。
//        CompletableFuture.supplyAsync(() ->{
//            System.out.println("步骤1。线程：" + Thread.currentThread().getName()); // 步骤1。线程：ForkJoinPool.commonPool-worker-25
//            return 1;
//        }).thenAcceptAsync(beforeResult->{
//            System.out.println("步骤2。上阶段结果为：" + beforeResult); // 步骤2。上阶段结果为：1
//            System.out.println("线程："  + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-25
//        });

        //thenApplyAsync：处理上阶段返回值，该阶段有返回值。
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
//            System.out.println("步骤1。线程：" + Thread.currentThread().getName()); // 步骤1。线程：ForkJoinPool.commonPool-worker-25
//            return 1;
//        }).thenApplyAsync(beforeResult -> {
//            System.out.println("步骤2。上阶段结果为：" + beforeResult); // 步骤2。上阶段结果为：1
//            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-25
//            return 2;
//        });
//        System.out.println(completableFuture.get()); // 2



        //thenCombineAsync:合并两个任务的结果，有返回值。
//        CompletableFuture<Integer> completableFuture =
//                CompletableFuture.supplyAsync(() -> {
//                    System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-25
//                    return 6;
//                }).thenCombineAsync(
//                        CompletableFuture.supplyAsync(() -> {
//                            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-25
//                            return 10;
//                        }),
//                        (one, two) -> {
//                            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-18
//                            return one + two;
//                });
//        System.out.println(completableFuture.get()); // 16
//        System.out.println(completableFuture.join()); // 16

        // thenAcceptBothAsync:合并两个任务的结果，无返回值。
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-25
//            return 1;
//        }).thenAcceptBothAsync(
//                CompletableFuture.supplyAsync(() -> {
//                    System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-18
//                    return 2;
//                }),
//                (one, two) -> {
//                    System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-18
//                    System.out.println(one + two); // 3
//                }
//        );



        //runAfterBoth: 两个任务执行完后，调用指定的操作
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println("第一阶段。线程：" + Thread.currentThread().getName()); // 第一阶段。线程：ForkJoinPool.commonPool-worker-25
//            return 6;
//        }).runAfterBothAsync(
//                CompletableFuture.runAsync(() -> System.out.println("第二阶段：线程：" + Thread.currentThread().getName())), // 第一阶段。线程：ForkJoinPool.commonPool-worker-25
//                () -> System.out.println("前面两个阶段都执行完成后执行该任务。线程：" + Thread.currentThread().getName())); // 前面两个阶段都执行完成后执行该任务。线程：ForkJoinPool.commonPool-worker-25

        //runAfterEither:两个任务任何一个正常完成后，调用指定的操作
//        CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("第一阶段。线程：" + Thread.currentThread().getName());
//            return 1;
//        }).runAfterEitherAsync(
//                CompletableFuture.runAsync(() -> {
//                    System.out.println("第二阶段。线程：" + Thread.currentThread().getName()); // 第二阶段。线程：ForkJoinPool.commonPool-worker-18
//                }),
//                () -> {
//                    System.out.println("两个阶段任何一个正常完成后，调用该操作。线程：" + Thread.currentThread().getName()); // 两个阶段任何一个正常完成后，调用该操作。线程：ForkJoinPool.commonPool-worker-18
//                }
//        );




        //whenComplete:当阶段完成后，将阶段的结果以及阶段的异常作为参数执行后续的操作
//        CompletableFuture.supplyAsync(() ->{
//            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-25
//            throw new RuntimeException();
////            return 1;
//        }).whenCompleteAsync((beforeResult, throwable) -> {
//            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-25
//            System.out.println("上阶段结果：" + beforeResult); // 上阶段结果：null
//            System.out.println("上阶段异常：" + throwable); // 上阶段异常：java.util.concurrent.CompletionException: java.lang.RuntimeException
//        });

        //whenCompose:当阶段正常完成后，该阶段的结果作为提供函数的参数执行函数
//        CompletableFuture.supplyAsync(() ->{
//            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-25
//            return 1;
//        }).thenComposeAsync((beforeResult) ->{
//            System.out.println("上阶段结果：" + beforeResult); // 上阶段结果：1
//            System.out.println("线程：" + Thread.currentThread().getName()); // 线程：ForkJoinPool.commonPool-worker-25
//            return CompletableFuture.completedFuture(beforeResult);
//        });



        //handle:当阶段完成后，将阶段的结果以及阶段的异常作为参数执行后续的操作
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> 1).handleAsync((r, throwable) -> r + 3);
//        System.out.println(completableFuture.join()); // 4


//        //complete: 完成操作，返回完成
        boolean completed = CompletableFuture.supplyAsync(() -> 1).complete(10);
        System.out.println("是否完成：" + completed); // 是否完成：true
//
        //completedFuture:返回包含指定值的CompletableFuture
        CompletableFuture<Integer> future = CompletableFuture.completedFuture(10);
        System.out.println("已经完成，值为：" + future.get()); // 已经完成，值为：10


    }
}
