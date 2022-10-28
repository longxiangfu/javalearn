package com.tc.hutoolTest.utilTest;


import cn.hutool.core.util.ClassLoaderUtil;

public class ClassLoaderTest {
    public static void main(String[] args) {
        // 加载类
        Class<?> classTest = ClassLoaderUtil.loadClass("java.lang.String");
        System.out.println(classTest.getName()); // java.lang.String

        // 指定的类是否被提供
        System.out.println(ClassLoaderUtil.isPresent("java.lang.String")); // true
    }
}
