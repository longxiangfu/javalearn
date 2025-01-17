package com.tc.jdk.foundation.dataStructure;

import cn.hutool.core.convert.Convert;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;

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
        TreeMap<String, Object> map = new TreeMap<>(); // public TreeMap(Comparator<? super K> comparator)
        map.put("name", "longxiangfu");
        map.put("age", 30);
        map.put("sex", "nan");
        System.out.println(Convert.toStr(map)); // {age=30, name=longxiangfu, sex=nan}


    }
}
