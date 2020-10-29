package com.tc.event.spring.selfOn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/eventOn")
public class EventOnAction {


    @GetMapping("/test")
    public void test(){
        log.info("我要测试某方法的onInvoke,onResponse,onError");
    }
}
