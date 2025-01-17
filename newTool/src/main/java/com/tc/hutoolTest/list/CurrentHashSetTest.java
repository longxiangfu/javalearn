package com.tc.hutoolTest.list;

import cn.hutool.core.collection.ConcurrentHashSet;

/**
 * jdk没有提供ConcurrentHashSet
 */
public class CurrentHashSetTest {
    public static void main(String[] args) {
        ConcurrentHashSet concurrentHashSet = new ConcurrentHashSet();
        concurrentHashSet.add("aaa");
    }
}
