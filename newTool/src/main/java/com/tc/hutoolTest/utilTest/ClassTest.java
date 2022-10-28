package com.tc.hutoolTest.utilTest;

import cn.hutool.core.util.ClassUtil;

public class ClassTest {
    public static void main(String[] args) {
        // 比较判断types1和types2两组类，如果types1中所有的类都与types2对应位置的类相同，或者是其父类或接口，则返回true
//        ClassUtil.isAllAssignableFrom()

        // 是否为包装类
//        ClassUtil.isPrimitiveWrapper();

        // 是否为基本类型
//        ClassUtil.isBasicType();

        // 获取给定类所在包的名称
//        ClassUtil.getClassPath();

        // 扫描包及包下所有的类
//        ClassUtil.scanPackage();

//        ClassUtil.getClassPath(); // 获取当前线程的ClassPath
//        ClassUtil.getJavaClassPaths(); // 获取java系统变量定义的ClassPath
//        ClassUtil.getContextClassLoader(); // 获取当前线程的ClassLoader
//        ClassUtil.getClassLoader(); // 获取当前线程的ClassLoader，获取失败时，则获取ClassLoaderUtil的ClassLoader
    }
}
