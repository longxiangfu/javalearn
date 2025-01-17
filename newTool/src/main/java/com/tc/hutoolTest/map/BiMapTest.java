package com.tc.hutoolTest.map;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.BiMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * BiMap：双向查找map
 * key和value都不能重复，但不强制
 */
public class BiMapTest {
    public static void main(String[] args) {
        BiMap<String, String> biMap = new BiMap<>(new HashMap<>());
        biMap.put("a", "aaa");
        biMap.put("b", "bbb");
        biMap.put("c", "ccc");

        System.out.println(biMap.get("a")); // aaa
        System.out.println(biMap.getKey("bbb")); // b




        // map 删除方式
        HashMap<String, String> map = new HashMap<>();
        map.put("lxf", "aa");
        map.put("lxf1", "bb");
        map.put("lxf2", "cc");
//        for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
//            String key = iterator.next();
//            if (!"lxf1".equals(key)) {
//                iterator.remove();
//            }
//        }
//        System.out.println(Convert.toStr(map)); // {lxf1=bb}  正确
//        map.keySet().removeIf(e-> "lxf1".equals(e));
//        System.out.println(Convert.toStr(map)); // {lxf2=cc, lxf=aa}  正确
//        map.values().removeIf(e -> "bb".equals(e));
//        System.out.println(Convert.toStr(map)); // {lxf2=cc, lxf=aa}  正确
//        map.entrySet().removeIf(e -> "lxf1".equals(e.getKey()));
//        System.out.println(Convert.toStr(map)); // {lxf2=cc, lxf=aa} 正确


            // 数组  没有删除
//        int[] numArray = {1, 3, 6};
//        for (int i = 0; i < numArray.length; i++) {
//            numArray[1] = 10;
//        }
//        System.out.println(Convert.toStr(numArray)); // [1, 10, 6]

            // list列表  删除方式
            List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
//        for (Integer value : list) {
//            if (1 != value) {
//                list.remove(value);
//            }
//        }
//        System.out.println(Convert.toStr(list)); // ConcurrentModificationException   错误
//        for (int i = 0; i < list.size(); i++) {
//            if (1 != list.get(i)) {
//                list.remove(list.get(i));
//            }
//        }
//        System.out.println(Convert.toStr(list)); // [1, 2, 3]   错误
//        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
//            Integer value = (Integer) iterator.next();
//            if (1 != value) {
//                iterator.remove();
//            }
//        }
//        System.out.println(Convert.toStr(list)); // [1]  正确
//        list.removeIf(e -> 1 != e);
//        System.out.println(Convert.toStr(list)); // [1]  正确

    }
}
