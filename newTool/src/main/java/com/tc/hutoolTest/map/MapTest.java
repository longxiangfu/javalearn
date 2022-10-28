package com.tc.hutoolTest.map;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;

import java.util.*;
import java.util.stream.Stream;

public class MapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        /**
         * isEmpty  isNotEmpty
         */
        System.out.println(MapUtil.isEmpty(map)); // false
        System.out.println(MapUtil.isNotEmpty(map)); // true

        /**
         * 将map按照给定的分隔符转换为字符串
         */
//        System.out.println(MapUtil.join(map, StrUtil.AT, StrUtil.UNDERLINE, false)); // a_aaa@b_bbb@c_ccc

        /**
         * filter过滤元素
         */
//        Map<String, String> filterMap = MapUtil.filter(map, (Filter<Map.Entry<String, String>>) t -> t.getValue().equals("aaa"));
//        System.out.println(Convert.toStr(filterMap)); // {a=aaa}

        /**
         * reverse 键值互换
         */
//        Map<String, String> reverseMap = MapUtil.reverse(map);
//        System.out.println(Convert.toStr(reverseMap)); // {aaa=a, ccc=c, bbb=b}

        /**
         * sort  排序
         */
//        HashMap<String, String> map = new HashMap<>();
//        map.put("a", "aaa");
//        map.put("c", "ccc");
//        map.put("b", "bbb");
//        TreeMap<String, String> sortMap = MapUtil.sort(map, (Comparator.comparingInt(String::hashCode)));
//        System.out.println(Convert.toStr(sortMap)); // {a=aaa, b=bbb, c=ccc}

        /**
         * getAny  获取map中部分key-value生成新的map
         */
//        Map<String, String> anyMap = MapUtil.getAny(map, "c");
//        System.out.println(Convert.toStr(anyMap)); // {c=ccc}


        /**
         * getXXX
         */
        String aValue = MapUtil.getStr(map, "a");
        System.out.println(aValue); // aaa
    }
}
