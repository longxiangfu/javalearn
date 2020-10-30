package com.tc.event.spring.selfOn;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 事件管理器
 */
@Component
public class EventOnManager {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;


    /**
     * 发布调用事件
     * @param event
     */
    public void publishInvokeEvent(EventOnInvoke event){
        applicationEventPublisher.publishEvent(event);
    }

    /**
     * 发布正常返回事件
     * @param event
     */
    public void publishResponseEvent(EventOnResponse event){
        applicationEventPublisher.publishEvent(event);
    }

    /**
     * 发布错误事件
     * @param event
     */
    public void publishErrorEvent(EventOnError event){
        applicationEventPublisher.publishEvent(event);
    }
}
