package com.tc.hutoolTest.list;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;

import java.util.*;

public class CollTest {
    public static void main(String[] args) {
        /**
         * join
         * 反方法 StrUtil.split
         */
//        ArrayList<String> arrayList = CollUtil.newArrayList("a", "b", "c", "d", "e");
//        String join = CollUtil.join(arrayList, "$");
//        System.out.println(join); // a$b$c$d$e

        /**
         * sortPageAll 排序分页
         */
//        Comparator comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        };
//        List<Integer> list2 = CollUtil.newArrayList(4, 5, 6);
//        List<Integer> list1 = CollUtil.newArrayList(1, 2, 3);
//        List<Integer> list3 = CollUtil.newArrayList(7, 8, 9);
//        List sortPageAllList = CollUtil.sortPageAll(0, 3, comparator, list1, list2, list3);
//        System.out.println(Convert.toStr(sortPageAllList)); // [1, 2, 3]

        /**
         * addAll
         */
//        List<Integer> list2 = CollUtil.newArrayList(4, 5, 6);
//        List<Integer> list1 = CollUtil.newArrayList(1, 2, 3);
//        Collection<Integer> list = CollUtil.addAll(list1, list2);
//        System.out.println(Convert.toStr(list)); // [1, 2, 3, 4, 5, 6]

        /**
         * isEmpty     isNotEmpty
         */
//        List<Integer> list = CollUtil.newArrayList(4, 5, 6);
//        System.out.println(CollUtil.isEmpty(list)); // false
//        System.out.println(CollUtil.isNotEmpty(list)); // true


        /**
         * zip
         */
//        ArrayList<String> list1 = CollUtil.newArrayList("a", "b", "c", "d");
//        ArrayList<Integer> list2 = CollUtil.newArrayList(1, 2, 3, 4);
//        Map<String, Integer> zipMap = CollUtil.zip(list1, list2);
//        System.out.println(Convert.toStr(zipMap)); // {a=1, b=2, c=3, d=4}

    }
}
