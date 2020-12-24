package com.tc.event.reactor.jichu;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * 打包操作符
 * 即将多个操作符封装成函数
 */
public class daBaoOpe {

    public static void main(String[] args) {
//        transformTest();
        composeTest();
    }

    /**
     * transform：将多个操作符封装起来
     */
    private static void transformTest(){
        Function<Flux<String>, Flux<String>> filterAndMap = f -> f.filter(color -> !color.equals("orange"))
                .map(String::toUpperCase);
        Flux.fromIterable(Arrays.asList("blue", "green", "orange", "purple"))
                .doOnNext(System.out::println)
                .transform(filterAndMap)
                .subscribe(d -> System.out.println("Subscriber to Transformed MapAndFilter:" + d));
//        blue
//        Subscriber to Transformed MapAndFilter:BLUE
//                green
//        Subscriber to Transformed MapAndFilter:GREEN
//                orange
//        purple
//        Subscriber to Transformed MapAndFilter:PURPLE

    }

    /**
     * compose:将多个函数封装起来。compose打包的函数是有状态的，transform打包的函数是无状态的
     */
    private static void composeTest(){
        //compose第一次订阅过滤掉orange,第二次订阅过滤掉purple
//        AtomicInteger state = new AtomicInteger(0);
//        Function<Flux<String>, Flux<String>> filterAndMap = f -> {
//            if (state.incrementAndGet() == 1){
//                return f.filter(color -> !color.equals("orange")).map(String::toUpperCase);
//            }
//            return f.filter(color -> !color.equals("purple")).map(String::toUpperCase);
//        };
//        Flux<String> composeFlux = Flux.fromIterable(Arrays.asList("blue", "green", "orange", "purple"))
//                .doOnNext(System.out::println)
//                .compose(filterAndMap);
//        composeFlux.subscribe(d -> System.out.println("Subscriber 1 to Composed MapAndFilter:" + d));
//        composeFlux.subscribe(d -> System.out.println("Subscriber to Composed MapAndFilter:" + d));
////        blue
////        Subscriber 1 to Composed MapAndFilter:BLUE
////                green
////        Subscriber 1 to Composed MapAndFilter:GREEN
////                orange
////        purple
////        Subscriber 1 to Composed MapAndFilter:PURPLE
////                blue
////        Subscriber to Composed MapAndFilter:BLUE
////                green
////        Subscriber to Composed MapAndFilter:GREEN
////                orange
////        Subscriber to Composed MapAndFilter:ORANGE
////                purple


        //transform两次订阅的操作链是一样的，都会过滤掉orange
        AtomicInteger state1 = new AtomicInteger(0);
        Function<Flux<String>, Flux<String>> filterAndMap1 = f -> {
            if (state1.incrementAndGet() == 1){
                return f.filter(color -> !color.equals("orange")).map(String::toUpperCase);
            }
            return f.filter(color -> !color.equals("purple")).map(String::toUpperCase);
        };
        Flux<String> composeFlux1 = Flux.fromIterable(Arrays.asList("blue", "green", "orange", "purple"))
                .doOnNext(System.out::println)
                .transform(filterAndMap1);
        composeFlux1.subscribe(d -> System.out.println("Subscriber 1 to Composed MapAndFilter:" + d));
        composeFlux1.subscribe(d -> System.out.println("Subscriber to Composed MapAndFilter:" + d));
//        blue
//        Subscriber 1 to Composed MapAndFilter:BLUE
//                green
//        Subscriber 1 to Composed MapAndFilter:GREEN
//                orange
//        purple
//        Subscriber 1 to Composed MapAndFilter:PURPLE
//                blue
//        Subscriber to Composed MapAndFilter:BLUE
//                green
//        Subscriber to Composed MapAndFilter:GREEN
//                orange
//        purple
//        Subscriber to Composed MapAndFilter:PURPLE

    }
}
