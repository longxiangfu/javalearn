package com.spring.spring.ioc;

import com.spring.spring.ioc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.util.Arrays;

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

        /*
        自定义BeanDefinition,并将BeanDefinition注册到Spring容器中
        参照new AnnotationConfigApplicationContext(AppConfig.class)的源码
         */
        //获取UserService对应的BeanDefinition
        BeanDefinition beanDefinition = new RootBeanDefinition(UserService.class);
        //获取BeanDefinitonRegistry  DefaultListableBeanFactory既是工厂又是注册器
        DefaultListableBeanFactory defaultListableBeanFactory = ((AnnotationConfigApplicationContext) context).getDefaultListableBeanFactory();
        //注册。以name为key，BeanDefinition为value放到beanDefinitionMap中
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);

        System.out.println(context.getBean("userService"));
    }


    /**
     * 装配方式：@Import
     */
    @Test
    public void testAnnotationImport(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean("user"));
    }

    /**
     * 装配方式：@ComponentScan+@Component
     */
    @Test
    public void testAnnotationComponent(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean("user"));
        System.out.println(context.getBean("fox"));
        System.out.println(context.getBean("userService"));
    }


    /**
     * 装配方式：xml
     */
    @Test
    public void testXml(){
        //获取ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println(context.getBean("user"));

        /*
         手动加载xml中bean,并将对应的BeanDefinition注册到spring容器中
         参照new ClassPathXmlApplicationContext("spring.xml")的源码
         */
        //获取ResourceLoader
        ResourceLoader loader = new DefaultResourceLoader();
        //加载Resource
        Resource resource = loader.getResource("spring.xml");
        //获取BeanDefinitionReader
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        //读取资源，并注册对应的BeanDefinition
        reader.loadBeanDefinitions(resource);
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        if (beanDefinitionNames != null && beanDefinitionNames.length != 0) {
            Arrays.stream(beanDefinitionNames).forEach(System.out::println);//user
        }
    }

}
