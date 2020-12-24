package com.tc.event.reactor.jichu;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Flux
 */
public class FluxDemo {
    public static void main(String[] args) throws InterruptedException {
//        parallelTest();
//        delayElementsTest();
        asyncNoBlockTest();
    }

    private static void asyncNoBlockTest() throws InterruptedException {
        Flux.just(1, 2, 3, 4, 5)
//                .delayElements(Duration.ofMillis(1000))
                .map(e -> e+100)
                .filter(e -> e % 2 == 0)
                .log()
                .subscribe(System.out::println);
        System.out.println("主线程：" + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * 测试delayElements
     */
    private static void delayElementsTest(){
        Flux.range(0, 10)
                .delayElements(Duration.ofMillis(1000))//默认使用Schedulers.parallel()
                .log()
                .blockLast();//订阅Flux,并且阻塞直到Flux中元素全部完成
//        2020-12-23 15:42:05.798 [main] INFO  reactor.Flux.ConcatMap.1 Line:274 - onSubscribe(FluxConcatMap.ConcatMapImmediate)
//        2020-12-23 15:42:05.808 [main] INFO  reactor.Flux.ConcatMap.1 Line:274 - request(unbounded)
//        2020-12-23 15:42:06.867 [parallel-1] INFO  reactor.Flux.ConcatMap.1 Line:274 - onNext(0)
//        2020-12-23 15:42:07.869 [parallel-2] INFO  reactor.Flux.ConcatMap.1 Line:274 - onNext(1)
//        2020-12-23 15:42:08.872 [parallel-3] INFO  reactor.Flux.ConcatMap.1 Line:274 - onNext(2)
//        2020-12-23 15:42:09.874 [parallel-4] INFO  reactor.Flux.ConcatMap.1 Line:274 - onNext(3)
//        2020-12-23 15:42:10.876 [parallel-1] INFO  reactor.Flux.ConcatMap.1 Line:274 - onNext(4)
//        2020-12-23 15:42:11.880 [parallel-2] INFO  reactor.Flux.ConcatMap.1 Line:274 - onNext(5)
//        2020-12-23 15:42:12.881 [parallel-3] INFO  reactor.Flux.ConcatMap.1 Line:274 - onNext(6)
//        2020-12-23 15:42:13.883 [parallel-4] INFO  reactor.Flux.ConcatMap.1 Line:274 - onNext(7)
//        2020-12-23 15:42:14.887 [parallel-1] INFO  reactor.Flux.ConcatMap.1 Line:274 - onNext(8)
//        2020-12-23 15:42:15.890 [parallel-2] INFO  reactor.Flux.ConcatMap.1 Line:274 - onNext(9)
//        2020-12-23 15:42:15.896 [parallel-2] INFO  reactor.Flux.ConcatMap.1 Line:274 - onComplete()
    }

    /**
     * 并行测试
     * @throws InterruptedException
     */
    private static void parallelTest() throws InterruptedException {
        //对于一些能够在一个线程中顺序执行的任务，即使调度到ParallelScheduler上，通常也只由一个Worker来执行
//		Flux.range(1, 4)
//				.publishOn(Schedulers.parallel())
//				.log()
//				.blockLast();
////        2020-12-23 15:33:44.044 [main] INFO  reactor.Flux.PublishOn.1 Line:274 - | onSubscribe([Fuseable] FluxPublishOn.PublishOnSubscriber)
////        2020-12-23 15:33:44.053 [main] INFO  reactor.Flux.PublishOn.1 Line:274 - | request(unbounded)
////        2020-12-23 15:33:44.058 [parallel-1] INFO  reactor.Flux.PublishOn.1 Line:274 - | onNext(1)
////        2020-12-23 15:33:44.058 [parallel-1] INFO  reactor.Flux.PublishOn.1 Line:274 - | onNext(2)
////        2020-12-23 15:33:44.059 [parallel-1] INFO  reactor.Flux.PublishOn.1 Line:274 - | onNext(3)
////        2020-12-23 15:33:44.059 [parallel-1] INFO  reactor.Flux.PublishOn.1 Line:274 - | onNext(4)
////        2020-12-23 15:33:44.060 [parallel-1] INFO  reactor.Flux.PublishOn.1 Line:274 - | onComplete()


        //对Flux使用parallel()操作符来得到一个ParallelFlux。不过这个操作符本身并不会进行并行处理，
        //而只是将负载划分到多个执行“轨道”上（默认情况下，轨道个数与CPU核数相等）。
        Flux.range(1, 4)
                .parallel(2)
                .runOn(Schedulers.parallel())
                .log()
                .subscribe();
        TimeUnit.MILLISECONDS.sleep(100);
//        2020-12-23 15:37:50.787 [main] INFO  reactor.Parallel.RunOn.1 Line:274 - onSubscribe([Fuseable] FluxPublishOn.PublishOnSubscriber)
//        2020-12-23 15:37:50.794 [main] INFO  reactor.Parallel.RunOn.1 Line:274 - request(unbounded)
//        2020-12-23 15:37:50.797 [main] INFO  reactor.Parallel.RunOn.1 Line:274 - onSubscribe([Fuseable] FluxPublishOn.PublishOnSubscriber)
//        2020-12-23 15:37:50.797 [main] INFO  reactor.Parallel.RunOn.1 Line:274 - request(unbounded)
//        2020-12-23 15:37:50.798 [parallel-1] INFO  reactor.Parallel.RunOn.1 Line:274 - onNext(1)
//        2020-12-23 15:37:50.799 [parallel-1] INFO  reactor.Parallel.RunOn.1 Line:274 - onNext(3)
//        2020-12-23 15:37:50.800 [parallel-1] INFO  reactor.Parallel.RunOn.1 Line:274 - onComplete()
//        2020-12-23 15:37:50.802 [parallel-2] INFO  reactor.Parallel.RunOn.1 Line:274 - onNext(2)
//        2020-12-23 15:37:50.803 [parallel-2] INFO  reactor.Parallel.RunOn.1 Line:274 - onNext(4)
//        2020-12-23 15:37:50.803 [parallel-2] INFO  reactor.Parallel.RunOn.1 Line:274 - onComplete()
    }
}
