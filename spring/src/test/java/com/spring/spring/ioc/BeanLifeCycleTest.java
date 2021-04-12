package com.spring.spring.ioc;

import com.spring.spring.beanLifeCycle.BeanLifeCycleConfig;
import com.spring.spring.beanLifeCycle.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanLifeCycleTest {

    /**
     * 测试bean和对象的区别
     * 1、bean是spring管理的对象
     * 2、bean会填充属性
     */
    @Test
    public void test(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BeanLifeCycleConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        UserService userService1 = new UserService();

    }


    /**
     * 测试bean的生命周期
     */
    @Test
    public void test1(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BeanLifeCycleConfig.class);
        System.out.println(context.getBean("userService"));
    }
}
