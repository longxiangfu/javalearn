package com.tc.event.spring.selfOn;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
@Aspect//定义切面
public class AopAspect {

    @Resource
    EventOnManager eventOnManager;

    //定义切点
    @Pointcut("execution(public * com.tc.event.spring.selfOn.EventOnAction.*(..))")
    public void broker(){}

    //定义环绕通知
    @Around("broker()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        try {
            log.info("前置通知");
            eventOnManager.publishInvokeEvent(new EventOnInvoke(this, "方法被调用"));
            pjp.proceed();
            log.info("最终通知");
            eventOnManager.publishResponseEvent(new EventOnResponse(this, "方法正常返回"));
        }catch (Throwable e){
            log.info("异常通知");
            eventOnManager.publishErrorEvent(new EventOnError(this, "方法调用异常"));
            throw new Throwable();
        }finally {
            log.info("后置通知（相当于‘最终通知’和‘异常通知’）");
        }

    }

}