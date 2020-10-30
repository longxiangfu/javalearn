package com.tc.event.spring.selfOn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 调用之前事件监听器。处理事件
 */
@Slf4j
@Component
public class EventOnInvokeListener implements ApplicationListener<EventOnInvoke> {


    @Override
    public void onApplicationEvent(EventOnInvoke event) {
        log.info("调用之前事件监听器receiver:" + event.getMessage());
    }
}
