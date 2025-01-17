package com.tc.hutoolTest.language;

import cn.hutool.core.lang.Console;

/**
 * Console 是对System.out.println的封装
 * 只是测试使用，实际环境中需要输出到日志文件中
 */
public class ConsoleTest {
    public static void main(String[] args) {
        // 直接打印数组
        String[] arr = new String[]{"a", "b"};
        Console.log(arr); //[a, b]

        // 模板语法
        Console.error("{}呵呵", "lxf");
    }
}
