package com.tc.hutoolTest.list;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.convert.Convert;

import java.util.ArrayList;
import java.util.Map;

public class IterTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = CollUtil.newArrayList(1, 2, 3, 4, 1);
//        System.out.println(IterUtil.isEmpty(list)); // false
//        System.out.println(IterUtil.isNotEmpty(list)); // true
//        System.out.println(IterUtil.hasNull(list)); // false
//        System.out.println(IterUtil.isAllNull(list)); // false

        /**
         * countMap  计数map
         */
//        Map<Integer, Integer> countMap = IterUtil.countMap(list.iterator());
//        System.out.println(Convert.toStr(countMap)); // {1=2, 2=1, 3=1, 4=1}

        /**
         * getElementType  获取元素类型
         */
//        Class<?> elementType = IterUtil.getElementType(list);
//        System.out.println(elementType); // class java.lang.Integer
    }
}
