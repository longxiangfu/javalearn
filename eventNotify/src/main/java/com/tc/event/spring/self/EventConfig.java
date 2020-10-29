package com.tc.event.spring.self;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import javax.annotation.Resource;

@Configuration
public class EventConfig {

    @Resource
    SimpleApplicationEventMulticaster simpleApplicationEventMulticaster;

    @Bean
    public SimpleAsyncTaskExecutor getSimpleAsyncTaskExecutor(){
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        simpleApplicationEventMulticaster.setTaskExecutor(simpleAsyncTaskExecutor);
        return simpleAsyncTaskExecutor;
    }
}
