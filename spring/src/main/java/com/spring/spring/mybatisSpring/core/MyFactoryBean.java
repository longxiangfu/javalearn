package com.spring.spring.mybatisSpring.core;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

public class MyFactoryBean implements FactoryBean {

    Class mapperInterface;

    public MyFactoryBean(Class mapperInterface){
        this.mapperInterface = mapperInterface;

    }

    @Override
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{mapperInterface},
                new MyInvocationHandler());
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}
