package com.spring.spring.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {

    /**
     * 装配方式：@Configureation + @Bean
     */
    @Test
    public void testAnnotationConfigrationAndBean(){
        //获取ioc容器
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //获取bean
        //若将AppConfig中方法userService注释掉，会报错：
        //org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'userService' available
        //BeanDefinition,bean定义,承载bean的属性，方法，构造器
        System.out.println(context.getBean("userService"));
    }
}
