package com.tc.jdk.concurrent.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * cas底层基础
 * cas底层都是通过Unsafe.compareAndSwapInt相关方法进行cas操作的
 */
public class UnsafeExample {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person p = new Person();

        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);
        long offset = unsafe.objectFieldOffset(p.getClass().getField("no"));

        System.out.println("Person.no：" + p.getNo()); // Person.no：0
        // 4个参数分别是：对象、字段的内存偏移量、字段期望值、字段新值
        boolean success = unsafe.compareAndSwapInt(p, offset, 0, 100);
        System.out.println("success:" + success + "  Person.no：" + p.getNo()); // success:true  Person.no：100

    }
}
