package com.tc.event.java;

import reactor.core.publisher.Flux;

import java.util.concurrent.Callable;

public class EventTest {
    public static void main(String[] args) {
//        //创建事件管理器
//        EventManager eventManager = new EventManager();
//        //向监听器容器中添加监听器
//        eventManager.addListener((event) -> System.out.println("我是匿名类监听器。监听到的事件：" + event.toString()));
//        eventManager.addListener(new EventListenerImpl());
//        //触发事件
//        eventManager.postEvent(new Event("", "89"));
////        我是匿名类监听器。监听到的事件：Event{str='89'}
////        我是默认监听器。监听到的事件：Event{str='89'}


        EventTest eventTest = new EventTest();
        eventTest.testFluxCreate();
    }


    /**
     * 将事件回调传入的事件包装成Flux流
     */
    private void testFluxCreate() {
//        //创建事件管理器
//        EventManager eventManager = new EventManager();
//        //向监听容器中添加监听器
//        Flux.create(fluxSink -> {
//            eventManager.addListener(new EventListener() {
//                @Override
//                public void onChange(Event event) {
//                    fluxSink.next(event);
//                }
//            });
//        }).subscribe(System.out::println);
//        //循环发出事件
//        for (int i = 0; i < 10; i++) {
//            eventManager.postEvent(new Event(this, String.valueOf(i)));
//        }
//    }

    EventManager eventManager = new EventManager();
    Flux.generate(sink -> {
        eventManager.addListener(new EventListener() {
            @Override
            public void onChange(Event event) {
                sink.next(event);//使用generate时，经debug，发现走不到这里,并且报错
            }
        });
    }).subscribe(System.out::println);
    eventManager.postEvent(new Event(this, String.valueOf(100)));
//        报错java.lang.IllegalStateException: The generator didn't call any of the SynchronousSink method
    }

}
