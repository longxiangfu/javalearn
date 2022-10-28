package com.tc.hutoolTest.utilTest;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

public class StringTest {
    public static void main(String[] args) {
        // 常用的方法例如isBlank、isNotBlank、isEmpty、isNotEmpty

        /**
         * hasBlank  hasEmpty
         */
//        System.out.println(StrUtil.hasEmpty("aaa ")); // false
//        System.out.println(StrUtil.hasBlank("fff dd ")); // false 还会判断不可见的字符，如空字符

        /**
         * removePrefix  removeSuffix
         */
//        System.out.println(StrUtil.removePrefix("www.long.jpg", "www.")); // long.jpg
//        System.out.println(StrUtil.removeSuffix("long.jpg", ".jpg")); // long


        /**
         * sub
         */
//        String str = "abcdefgh";
//        System.out.println(StrUtil.sub(str, 2, 3)); // c
//        System.out.println(StrUtil.sub(str, 2, -3)); // cde
//        System.out.println(StrUtil.sub(str, 3, 2)); // c

        /**
         * str   bytes
         */
//        byte[] abcs = StrUtil.bytes("abc", "utf-8");
//        System.out.println(abcs); // [B@18025c
//        System.out.println(StrUtil.str(abcs, "utf-8")); // abc

        /**
         * format
         */
//        System.out.println(StrUtil.format("{}爱{},就像老鼠爱大米", "我", "你")); // 我爱你,就像老鼠爱大米

        /**
         * 常量
         */
        System.out.println(StrUtil.AT);
    }
}
