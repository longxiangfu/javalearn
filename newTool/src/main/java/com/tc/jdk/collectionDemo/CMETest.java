package com.tc.jdk.collectionDemo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ConcurrentModificationException
 * modCount: ArrayList被修改的次数，包括新增、修改、删除
 * expectedModCount: 迭代器创建时，记录的modCount的值
 * 迭代器遍历过程中，每一次遍历前都会判断，如果modCount和expectedModCount不相等，说明集合被修改了，就会抛异常，保证集合遍历的时候不被修改
 * 解决方法：1.使用Iterator.remove()
 * 2.使用CopyOnWriteArrayList:修改时，底层是复制--修改--赋值，
 * 见D:\java_lean\src\main\java\com\lxf\jdk8\concurrent\CopyOnWriteArrayListTest.java
 */
public class CMETest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        // 获取userNames的modCount值
        Field modCountField = ArrayList.class.getSuperclass().getDeclaredField("modCount");
        modCountField.setAccessible(true);
        int modCount = (int) modCountField.get(userNames);
        System.out.println("modCount: " + modCount);

        for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                //调用ArrayList.remove(),实际底层是内部类Iterator迭代器进行迭代
                userNames.remove(userName);

            }
        }
        System.out.println(userNames);
    }
}
