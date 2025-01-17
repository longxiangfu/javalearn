package com.tc.hutoolTest.utilTest;

import cn.hutool.core.math.MathUtil;

public class MathTest {
    public static void main(String[] args) {
        MathUtil.arrangementCount(10, 8); // 排列  计算排列数，即A(n, m) = n!/(n-m)!
        MathUtil.combinationCount(10, 8); // 组合  计算组合数，即C(n, m) = n!/((n-m)! * m!)
    }
}
