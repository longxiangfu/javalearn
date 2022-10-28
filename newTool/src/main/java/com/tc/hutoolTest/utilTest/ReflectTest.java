package com.tc.hutoolTest.utilTest;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;

import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) {
        // 获取所有方法
        Method[] methods = ReflectUtil.getMethods(TestClass.class);
        System.out.println(methods);
        // 获取类的指定方法
        Method getA = ReflectUtil.getMethod(TestClass.class, "getA");
        System.out.println(getA);
        // 构造对象
        TestClass testClass = ReflectUtil.newInstance(TestClass.class, 20);
        // 执行方法
        ReflectUtil.invoke(testClass, "setA", 100000); // 100000

    }


}
