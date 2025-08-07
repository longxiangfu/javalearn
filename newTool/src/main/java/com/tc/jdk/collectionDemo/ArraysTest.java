package com.tc.jdk.collectionDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Arrays工具类
 */
public class ArraysTest {

    public static void main(String[] args) {
        String[] strArray = new String[]{"a", "b", "c"};

        List<String> list = Arrays.asList(strArray);//返回Arrays的内部类
        System.out.println(list);//[a, b, c]

        /*
        Arrays内部的集合类，只能获取和修改，不能添加和删除，因为内部类没有添加和删除方法
         */
//        System.out.println(list.get(0));//获取
//        System.out.println(String.valueOf(list.contains("b")));//获取
//        list.set(2, "ccccccc");
//        System.out.println(list.get(2));//修改
//        list.add("g");//添加 不允许 报错
//        list.remove("a");//删除 不允许 报错


        /*
         * 内部集合类元素和原数组元素引用的对象地址一样，修改数组的元素也会影响内部集合类元素
         */
//        int length = strArray.length;
//        for (int i = 0; i < length; i++) {
//            strArray[i] = strArray[i] + "123";
//        }
//        System.out.println(list);//[a123, b123, c123]


        /*
        正确的做法
         */
        List<String> newList = new ArrayList<>();
        Collections.addAll(newList, strArray);
        System.out.println(newList);
        int length = strArray.length;
        for (int i = 0; i < length; i++) {
            strArray[i] = strArray[i] + "123";
        }
        System.out.println(newList);


    }
}
