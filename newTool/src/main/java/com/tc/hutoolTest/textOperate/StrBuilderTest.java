package com.tc.hutoolTest.textOperate;

import cn.hutool.core.lang.Console;
import cn.hutool.core.text.StrBuilder;

public class StrBuilderTest {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("a").append("b");
        Console.log(builder); // ab
        builder = new StringBuilder();  // 生成新的字符串需要重新new，开辟新的内存空间
        builder.append("c").append("d");
        Console.log(builder); // cd


        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("a").append("b");
        Console.log(strBuilder); // ab
        strBuilder.reset(); // 生成新的字符串不需要开辟新的内存空间
        strBuilder.append("c").append("d");
        Console.log(strBuilder); // cd
    }
}
