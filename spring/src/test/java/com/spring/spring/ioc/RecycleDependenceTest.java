package com.spring.spring.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 循环依赖 测试
 */
public class RecycleDependenceTest {

    /**
     * 依赖注入的方式：
     * 1.构造器注入：bean在实例化时，其构造器中依赖的参数进行实例化、属性填充和初始化，然后可以在其构造函数中手动将依赖赋值给自己的属性
     * 2.属性注入：bean属性填充（populateBean）时，对有@Autowired和@Resource注解的属性进行实例化、属性填充和初始化，然后将依赖赋值给自己的属性
     * 3.setter注入
     */
    @Test
    public void diTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
        System.out.println(context.getBean("people"));
    }


    /**
     * 循环依赖的现象: 不正常
     */
    @Test
    public void recycleDiTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
        System.out.println(context.getBean("monkey"));
//        Error creating bean with name 'fish': Requested bean is currently in creation: Is there an unresolvable circular reference?
    }


    /**
     * 循环依赖的现象：正常
     */
    @Test
    public void recycleDiTest1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
    }


}
