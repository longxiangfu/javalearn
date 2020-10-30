package com.tc.event.spring.selfOn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 错误事件监听器。处理事件
 */
@Slf4j
@Component
public class EventOnErrorListener implements ApplicationListener<EventOnError> {


    @Override
    public void onApplicationEvent(EventOnError event) {
        log.info("错误事件监听器receiver:" + event.getMessage());
    }
}
