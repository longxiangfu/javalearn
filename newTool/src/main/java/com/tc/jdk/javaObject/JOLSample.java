package com.tc.jdk.javaObject;

import org.openjdk.jol.info.ClassLayout;

/**
 * 分析jvm对象内存占用
 */
public class JOLSample {
    public static void main(String[] args) {
        ClassLayout layout = ClassLayout.parseInstance(new Object());
        System.out.println(layout.toPrintable());

        ClassLayout layout1 = ClassLayout.parseInstance(new int[]{});
        System.out.println(layout1.toPrintable());

        ClassLayout layout2 = ClassLayout.parseInstance(new A());
        System.out.println(layout2.toPrintable());
    }

    public static class A {
        int id; // 4字节
        String name; // 类型指针，开启指针压缩为4字节，否则为8字节
        byte b; // 1字节
        Object o; // 类型指针
    }

}
