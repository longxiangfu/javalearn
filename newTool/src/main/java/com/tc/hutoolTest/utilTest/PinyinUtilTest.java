package com.tc.hutoolTest.utilTest;

import cn.hutool.extra.pinyin.PinyinUtil;

/**
 * 拼音工具
 */
public class PinyinUtilTest {
    public static void main(String[] args) {
        String pinyin = PinyinUtil.getPinyin("你好");
        System.out.println(pinyin); // ni hao

        String firstLetter = PinyinUtil.getFirstLetter("H是第一个", ", ");
        System.out.println(firstLetter); // h, s, d, y, g
    }
}
