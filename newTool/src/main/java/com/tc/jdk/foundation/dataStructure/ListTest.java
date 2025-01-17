package com.tc.jdk.foundation.dataStructure;

import cn.hutool.core.convert.Convert;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 列表   有序可重复
 */
public class ListTest {
    public static void main(String[] args) {
        // ArrayList
        List list = new ArrayList<String>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        System.out.println(list.indexOf(2));
        System.out.println(Convert.toStr(list)); // [1, 2, 3, 3]


        // LinkedList
//        List list = new LinkedList();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println(Convert.toStr(list)); // [1, 2, 3]


        // ArrayDeque  队列-先进先出
//        ArrayDeque<Integer> integers = new ArrayDeque<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        System.out.println(Convert.toStr(integers)); // [1, 2, 3]
//        System.out.println(integers.poll()); // 1


        // ArrayDeque  栈 先进后出
//        ArrayDeque<Integer> integers = new ArrayDeque<>();
//        integers.push(1);
//        integers.push(2);
//        integers.push(3);
//        System.out.println(Convert.toStr(integers)); // [3, 2, 1]
//        System.out.println(integers.pop()); // 3
    }
}
