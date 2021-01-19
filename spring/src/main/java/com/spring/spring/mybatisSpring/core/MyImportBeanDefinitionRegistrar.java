package com.spring.spring.mybatisSpring.core;

import com.spring.spring.mybatisSpring.dao.SchoolMapper;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //针对多个mapper的情况，可以自定义mapper扫描注解，将需要的mapper接口的全限定名获取到，然后在这里循环  TODO

        BeanDefinition beanDefinition = new RootBeanDefinition(MyFactoryBean.class);
        //填充属性
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.spring.spring.mybatisSpring.dao.SchoolMapper");
        //注册bean
//        registry.registerBeanDefinition("myFactoryBean", beanDefinition);

        registry.registerBeanDefinition("schoolMapper", beanDefinition);
    }
}
