package com.tc.jdk.foundation.dataStructure;

import cn.hutool.core.convert.Convert;

import java.util.*;

/**
 * map
 * 1、符号  {}
 */
public class MapTest {
    public static void main(String[] args) {
        // HashMap  key无序
//        HashMap map = new HashMap<String, Object>();
//        map.put("name", "longxiangfu");
//        map.put("age", 30);
//        map.put("sex", "nan");
//        System.out.println(Convert.toStr(map)); // {sex=nan, name=longxiangfu, age=30}


        // LinkedHashMap  key有序
//        LinkedHashMap map = new LinkedHashMap<String, Object>();
//        map.put("name", "longxiangfu");
//        map.put("age", 30);
//        map.put("sex", "nan");
//        System.out.println(Convert.toStr(map)); // {name=longxiangfu, age=30, sex=nan}


        // TreeMap  key有序
//        TreeMap<String, Object> map = new TreeMap<>(); // public TreeMap(Comparator<? super K> comparator)
//        map.put("name", "longxiangfu");
//        map.put("age", 30);
//        map.put("sex", "nan");
//        System.out.println(Convert.toStr(map)); // {age=30, name=longxiangfu, sex=nan}


        // 经过实验，hashmap在遍历时删除元素不会报错
//        HashMap map = new HashMap<String, String>();
//        map.put("name", "longxiangfu");
//        map.put("age", "30");
//        map.put("sex", "nan");
//        Set<Map.Entry<String, String>> set = map.entrySet();
//        for (Map.Entry<String, String> entry : set) {
//            if (entry.getKey().equals("age")) {
//                map.remove(entry.getKey());
//            }
//        }
//        System.out.println(map);




    }
}
