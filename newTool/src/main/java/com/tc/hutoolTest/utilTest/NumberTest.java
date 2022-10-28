package com.tc.hutoolTest.utilTest;


import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ServiceLoaderUtil;
import cn.hutool.core.util.StrUtil;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;

public class NumberTest {
    public static void main(String[] args) {
        /**
         * 加减乘除
         * RoundingMode.HALF_UP：四舍五入
         * RoundingMode.UP 舍位
         * RoundingMode.DOWN 进位
         *
         */
//        double a = 23.7393;
//        double b = 53.2224;
//        System.out.println(NumberUtil.add(a, b));
//        System.out.println(NumberUtil.sub(b, a));
//        System.out.println(NumberUtil.mul(a, b));
//        System.out.println(NumberUtil.div(b, a, 2, RoundingMode.HALF_UP));

        /**
         * 保留小数
         */
//        System.out.println(NumberUtil.round(4.5326, 2, RoundingMode.HALF_UP)); // 4.53
//        System.out.println(NumberUtil.round(4.5366, 2, RoundingMode.HALF_UP)); // 4.54
//        System.out.println(NumberUtil.round(4.5366, 2, RoundingMode.UP)); // 4.54
//        System.out.println(NumberUtil.round(4.5316, 2, RoundingMode.UP)); // 4.54
//        System.out.println(NumberUtil.round(4.5366, 2, RoundingMode.DOWN)); // 4.53
//        System.out.println(NumberUtil.round(4.5316, 2, RoundingMode.DOWN)); // 4.53

        /**
         * NumberUtil.isNumber 是否为数字
         * NumberUtil.isInteger 是否为整数
         * NumberUtil.isDouble 是否为浮点数
         * NumberUtil.isPrimes 是否为质数
         */
//        System.out.println(NumberUtil.isNumber("a")); // false
//        System.out.println(NumberUtil.isNumber("100")); // true
//        System.out.println(NumberUtil.isInteger("100")); // true
//        System.out.println(NumberUtil.isInteger("100.52")); // false
//        System.out.println(NumberUtil.isPrimes(3)); // true
//        System.out.println(NumberUtil.isPrimes(4)); // false


        /**
         * 生成随机数
         */
//        int[] ints = NumberUtil.generateRandomNumber(10, 20, 2);
//        System.out.println(Convert.toStr(ints)); // [11, 18]

        /**
         * 整数列表
         */
//        int[] range = NumberUtil.range(1, 20, 2); // [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
//        System.out.println(Convert.toStr(range)); // [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
//        Collection<?> collection = Convert.toCollection(ArrayList.class, Integer.class, range);
//        System.out.println(Convert.toStr(collection)); // [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
//        System.out.println(collection.getClass().getName()); // [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]

        /**
         * NumberUtil.factorial 阶乘
         * NumberUtil.sqrt 平方根
         * NumberUtil.divisor 最大公约数
         * NumberUtil.multiple 最小公倍数
         * NumberUtil.getBinaryStr 获得数字对应的二进制字符串
         * NumberUtil.binaryToInt 二进制转int
         * NumberUtil.binaryToLong 二进制转long
         * NumberUtil.compare 比较两个值的大小
         * NumberUtil.toStr 数字转字符串，自动并去除尾小数点儿后多余的0
         */
        System.out.println(NumberUtil.factorial(10)); // 3628800
        System.out.println(NumberUtil.sqrt(100)); // 10
        System.out.println(NumberUtil.divisor(100, 90)); // 10
        System.out.println(NumberUtil.multiple(3, 2)); // 6
        System.out.println(NumberUtil.getBinaryStr(100)); // 1100100
//        System.out.println(NumberUtil.binaryToInt());
//        System.out.println(NumberUtil.binaryToLong());
        System.out.println(NumberUtil.compare(100, 34)); // a>b时返回1  a<b时返回0

    }

}
