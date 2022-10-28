package com.tc.hutoolTest.map;

import cn.hutool.core.map.BiMap;

import java.util.HashMap;

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
    }
}
