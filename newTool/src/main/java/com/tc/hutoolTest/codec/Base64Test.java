package com.tc.hutoolTest.codec;

import cn.hutool.core.codec.Base64;

public class Base64Test {

    public static void main(String[] args) {
        String a = "伦家是一个非常长的字符串";
        String encode = Base64.encode(a);
        String decodeStr = Base64.decodeStr(encode);
        System.out.println("编码后：" + encode); // 编码后：5Lym5a625piv5LiA5Liq6Z2e5bi46ZW/55qE5a2X56ym5Liy
        System.out.println("解码后：" + decodeStr); // 解码后：伦家是一个非常长的字符串
    }
}
