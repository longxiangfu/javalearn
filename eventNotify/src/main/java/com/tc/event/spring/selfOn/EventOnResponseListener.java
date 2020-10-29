package com.tc.event.spring.selfOn;

import com.tc.event.spring.self.EventDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 正常返回之前事件监听器。处理事件
 */
@Slf4j
@Component
public class EventOnResponseListener implements ApplicationListener<EventDemo> {


    @Override
    public void onApplicationEvent(EventDemo event) {
        log.info("正常返回之前事件监听器receiver:" + event.getMessage());
    }
}
