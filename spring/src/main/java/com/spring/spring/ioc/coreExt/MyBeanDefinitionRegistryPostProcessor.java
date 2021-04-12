package com.spring.spring.ioc.coreExt;

import com.spring.spring.ioc.bean.Fox;
import com.spring.spring.ioc.bean.User;
import com.spring.spring.ioc.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * spring核心扩展点
 * 通过BeanDefinitionRegistryPostProcessor注册BeanDefinition
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinition beanDefinition = new RootBeanDefinition(User.class);
        beanDefinition.getPropertyValues().add("name", "longxiangfu");//添加属性值
        registry.registerBeanDefinition("user", beanDefinition);

        BeanDefinition definition = new RootBeanDefinition(UserService.class);
        //设置userService的构造器的模式，默认实例化是调用无参构造器，这里设置3，表示调用有餐构造器
        ((RootBeanDefinition) definition).setAutowireMode(3);
        registry.registerBeanDefinition("userService", definition);

//        beanDefinition.setBeanClassName(""); // beanClass
//        beanDefinition.setScope(""); // 单例 原型 request session application
//        beanDefinition.setLazyInit(true); // 延迟加载
//        beanDefinition.setInitMethodName(""); // 初始化方法
//        ((RootBeanDefinition) beanDefinition).setAutowireMode(3); // autowireMode构造推断
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //注册单例bean到单例缓存池
        beanFactory.registerSingleton("fox", new Fox());
    }
}
