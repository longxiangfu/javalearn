package com.tc.event.spring.self;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 事件管理器
 */
@Component
public class EventDemoManager {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;


    /**
     * 触发事件（发布事件）
     * @param eventDemo
     */
    public void publish(EventDemo eventDemo){
        applicationEventPublisher.publishEvent(eventDemo);
    }
}
