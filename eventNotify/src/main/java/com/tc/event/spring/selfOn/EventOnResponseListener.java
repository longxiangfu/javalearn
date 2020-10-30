package com.tc.event.spring.selfOn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 正常返回之前事件监听器。处理事件
 */
@Slf4j
@Component
public class EventOnResponseListener implements ApplicationListener<EventOnResponse> {


    @Override
    public void onApplicationEvent(EventOnResponse event) {
        log.info("正常返回之前事件监听器receiver:" + event.getMessage());
    }
}
