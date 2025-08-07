package com.tc.jdk.foundation.string;

import cn.hutool.core.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 进制转换
 */
public class StringTest3 {
    public static void main(String[] args) {
        // 十进制转其他进制
        System.out.println(Integer.toString(10, 2)); // 1010
        System.out.println(Integer.toString(10, 16)); // a

        // 其他进制转十进制
        System.out.println(Integer.parseInt("1010", 2)); // 10
        System.out.println(Integer.parseInt("a", 16)); // 10

    }

}
