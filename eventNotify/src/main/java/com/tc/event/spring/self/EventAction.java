package com.tc.event.spring.self;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/event")
public class EventAction {

    @Resource
    EventDemoManager eventDemoManager;


    @GetMapping("/aa.test")
    public void test(){
        EventDemo  eventDemo = new EventDemo(this, "100");
        eventDemoManager.publish(eventDemo);
    }
}
