package com.spring.spring.mybatisSpring;

import com.spring.spring.mybatisSpring.core.MyFactoryBean;
import com.spring.spring.mybatisSpring.core.MyInvocationHandler;
import com.spring.spring.mybatisSpring.dao.AccountMapper;
import com.spring.spring.mybatisSpring.dao.SchoolMapper;
import com.spring.spring.mybatisSpring.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

public class MybatisSpringTest {


    /**
     * 测试原始的
     */
    @Test
    public void originTest(){
        //获取spring容器
        ApplicationContext context = new AnnotationConfigApplicationContext(MybatisSpringConfig.class);
        //获取bean  userMapper是jdk动态代理
        //有很多业务mapper时，就不适合用@Bean的方式创建MapperFactoryBean
        UserMapper userMapper = (UserMapper)context.getBean("userMapper");
        System.out.println(userMapper.query());
    }


    /**
     * 测试@MapperScan
     */
    @Test
    public void mapperScanTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MybatisSpringConfig.class);
        UserMapper userMapper = (UserMapper)context.getBean("userMapper");
        System.out.println(userMapper.query());
        AccountMapper accountMapper = (AccountMapper)context.getBean("accountMapper");
        System.out.println(accountMapper.query());
    }

    /**
     * 测试FactotyBean
     */
    @Test
    public void factotyBeanTest(){
        //1、获取SchoolMapper代理对象
//        SchoolMapper schoolMapper = (SchoolMapper)Proxy.newProxyInstance(this.getClass().getClassLoader(),
//                new Class[]{SchoolMapper.class},
//                new MyInvocationHandler());
//        schoolMapper.query();
        //2、将代理类交给spring容器
        //bean的装配方式 @Component是加在类上的，不能使用    @Bean有好多Mapper时需要写好多
        //所以使用FactotyBean
        //2.1此时MyFactory是通过@Bean的方式交给spring容器的,不灵活
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        ((SchoolMapper)context.getBean("myFactoryBean")).query();//select * from school
        //2.2 MyFactory通过BeanDefinitionRegistrar+@Import方式交给spring容器的
        ApplicationContext context = new AnnotationConfigApplicationContext(MybatisSpringConfig.class);
//        SchoolMapper schoolMapper = (SchoolMapper)context.getBean("myFactoryBean");//根据注册时的beanName获取
        SchoolMapper schoolMapper = (SchoolMapper)context.getBean("schoolMapper"); //前面不加&,获取的是getObject方法的返回值
        MyFactoryBean myFactoryBean = (MyFactoryBean)context.getBean("&schoolMapper"); //前面加上&,获取的是FactoryBean本身
        System.out.println(myFactoryBean);
        schoolMapper.query();
        //2.3 在mybatis-spring中，@MapperScan原理类似我们这里
        //在springboot中，@Mapper使用的后置处理器

    }
}
