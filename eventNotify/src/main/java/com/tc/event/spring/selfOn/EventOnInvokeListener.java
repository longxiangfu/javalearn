package com.tc.event.spring.selfOn;

import com.tc.event.spring.self.EventDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 调用之前事件监听器。处理事件
 */
@Slf4j
@Component
public class EventOnInvokeListener implements ApplicationListener<EventDemo> {


    @Override
    public void onApplicationEvent(EventDemo event) {
        log.info("调用之前事件监听器receiver:" + event.getMessage());
    }
}
