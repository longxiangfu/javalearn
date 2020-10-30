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

//2020-10-30 13:46:21.155 [http-nio-8081-exec-2] INFO  com.tc.event.spring.selfOn.AopAspect Line:30  - 前置通知
//2020-10-30 13:46:21.157 [SimpleAsyncTaskExecutor-15] INFO  com.tc.event.spring.selfOn.EventOnInvokeListener Line:17  - 调用之前事件监听器receiver:方法被调用
//2020-10-30 13:46:21.163 [http-nio-8081-exec-2] INFO  com.tc.event.spring.selfOn.EventOnAction Line:16  - 我要测试某方法的onInvoke,onResponse,onError
//2020-10-30 13:46:21.164 [http-nio-8081-exec-2] INFO  com.tc.event.spring.selfOn.AopAspect Line:33  - 最终通知
//2020-10-30 13:46:21.165 [http-nio-8081-exec-2] INFO  com.tc.event.spring.selfOn.AopAspect Line:40  - 后置通知（相当于‘最终通知’和‘异常通知’）
//2020-10-30 13:46:21.166 [SimpleAsyncTaskExecutor-17] INFO  com.tc.event.spring.selfOn.EventOnResponseListener Line:17  - 正常返回之前事件监听器receiver:方法正常返回
}
