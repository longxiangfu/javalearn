package com.spring.spring.beanLifeCycle.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * BeanFactoryPostProcessor
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * 可以处理BeanDefinition
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("beanLifeCycleUserService");
        // 修改beanClass
//        beanDefinition.setBeanClass(Person.class);
        // 给属性赋值
        beanDefinition.getPropertyValues().add("userName", "龙相甫大佬");
    }
}
