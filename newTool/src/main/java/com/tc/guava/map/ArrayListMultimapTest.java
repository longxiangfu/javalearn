package com.tc.guava.map;

import cn.hutool.core.convert.Convert;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.Map;

/**
 * 多值Map
 */
public class ArrayListMultimapTest {
    public static void main(String[] args) {
        Multimap<String, Integer> multimap = ArrayListMultimap.create();
        // 增加
        multimap.put("day", 1);
        multimap.put("day", 2);
        multimap.put("day", 3);
        multimap.put("month", 8);

        // 查询
        Collection<Integer> days = multimap.get("day");
        System.out.println(Convert.toStr(days)); // [1, 2, 3]

        // 转换为Map<k, Collection>
        Map<String, Collection<Integer>> asMap = multimap.asMap();
        System.out.println(Convert.toStr(asMap)); // {month=[8], day=[1, 2, 3]}
    }
}
