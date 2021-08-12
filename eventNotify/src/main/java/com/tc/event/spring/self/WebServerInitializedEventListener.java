package com.tc.event.spring.self;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * web容器启动完成监听器
 */
@Component
public class WebServerInitializedEventListener implements ApplicationListener<WebServerInitializedEvent> {
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        System.out.println("web容器启动完成");
    }
}
