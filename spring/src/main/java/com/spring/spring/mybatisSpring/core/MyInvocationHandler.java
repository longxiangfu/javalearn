package com.spring.spring.mybatisSpring.core;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //打印sql   再加上Sqlsession就可以操作数据库了
        System.out.println(method.getAnnotation(Select.class).value()[0]);
        return null;
    }
}
