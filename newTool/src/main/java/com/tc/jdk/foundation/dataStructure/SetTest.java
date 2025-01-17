package com.tc.jdk.foundation.dataStructure;

import cn.hutool.core.convert.Convert;

import java.util.*;

/**
 * 集合  无序或有序不可重复
 */
public class SetTest {
    public static void main(String[] args) {
        // HashSet  无序
//        Set set = new HashSet<Integer>();
//        set.add(1);
//        set.add(3);
//        set.add(2);
//        System.out.println(Convert.toStr(set)); // [1, 2, 3]


        // LinkedHashSet 有序
//        LinkedHashSet<Integer> integers = new LinkedHashSet<>();
//        integers.add(1);
//        integers.add(3);
//        integers.add(2);
//        System.out.println(Convert.toStr(integers)); // [1, 3, 2]

        // TreeSet 有序  默认自然排序
        TreeSet<Integer> integers = new TreeSet<>(); // public TreeSet(Comparator<? super E> comparator)
        integers.add(1);
        integers.add(3);
        integers.add(2);
        System.out.println(Convert.toStr(integers)); // [1, 2, 3]

    }
}
