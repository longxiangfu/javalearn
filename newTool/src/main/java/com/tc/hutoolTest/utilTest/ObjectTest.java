package com.tc.hutoolTest.utilTest;

import cn.hutool.core.util.ObjectUtil;

import java.util.HashMap;

public class ObjectTest {
    public static void main(String[] args) {
        /**
         * 默认值
         */
////        final String name = null;
//        final String name = "小强";
////        public static <T, R> T defaultIfNull(R source, Function<R, ? extends T> handle, final T defaultValue){}
//        Object ob = ObjectUtil.defaultIfNull(name, (source) ->name + "，不为null时走这里", "为null时走这里");
//        System.out.println(ob);

        /**
         * ObjectUtil.equal
         */
//        Object a = null;
//        Object b = null;
//        System.out.println(ObjectUtil.equal(a, b));// true


        /**
         * ObjectUtil.length
         */
//        int[] array = new int[]{1, 2, 3, 4, 5};
//        System.out.println(ObjectUtil.length(array)); // 5
//        HashMap<String, String> map = new HashMap<>();
//        map.put("a", "a1");
//        map.put("b", "b1");
//        map.put("c", "c1");
//        System.out.println(ObjectUtil.length(map)); // 3


        /**
         * ObjectUtil.contains:
         * String
         * Collection
         * Map
         * Iterator
         * Enumeration
         * Array
         */
//        int[] array = new int[]{1, 2, 3, 4, 5};
//        System.out.println(ObjectUtil.contains(array, 2)); // true

        /**
         * ObjectUtil.isNull
         * ObjectUtil.isNotNull
         */
//        ObjectUtil.isNull(null);
//        ObjectUtil.isNotNull(null);


        /**
         * 克隆
         */
//        ObjectUtil.clone();

        /**
         * 序列化 反序列化
         */
//        ObjectUtil.serialize();
//        ObjectUtil.deserialize();


        /**
         * 是否为基本类型，包括包装类型和非包装类型
         */
        int a = 1;
        System.out.println(ObjectUtil.isBasicType(a)); // true

    }
}
