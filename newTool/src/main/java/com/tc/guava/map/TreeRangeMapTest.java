package com.tc.guava.map;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 * 范围Map
 */
public class TreeRangeMapTest {
    public static void main(String[] args) {
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closedOpen(0, 60), "D");
        rangeMap.put(Range.closedOpen(60, 80), "C");
        rangeMap.put(Range.closedOpen(80, 90), "B");
        rangeMap.put(Range.closedOpen(90, 100), "A");
        System.out.println(rangeMap.get(60)); // C
        System.out.println(rangeMap.get(95)); // A
    }
}
