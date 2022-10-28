package com.tc.hutoolTest.utilTest;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;

import java.nio.charset.Charset;

public class HexTest {
    public static void main(String[] args) {
        String hexStr = HexUtil.encodeHexStr("我是一个字符串", CharsetUtil.CHARSET_UTF_8);
        System.out.println(hexStr); // e68891e698afe4b880e4b8aae5ad97e7aca6e4b8b2
        System.out.println(HexUtil.decodeHexStr(hexStr, CharsetUtil.CHARSET_UTF_8)); // 我是一个字符串
    }
}
