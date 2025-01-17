package com.tc.hutoolTest.compare;

import cn.hutool.core.comparator.CompareUtil;

import java.util.Comparator;

/**
 * 比较器CompareUtil考虑到了null
 * 而jdk中的比较器没有考虑null
 */
public class CompareTest {
    public static void main(String[] args) {
        System.out.println(CompareUtil.compare(null, "a", true)); // 1
        System.out.println(CompareUtil.compare(null, "a", false)); // -1
    }
}
