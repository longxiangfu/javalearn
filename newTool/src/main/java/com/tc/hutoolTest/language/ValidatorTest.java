package com.tc.hutoolTest.language;

import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Validator;

/**
 * 表单是否符合条件
 */
public class ValidatorTest {
    public static void main(String[] args) {
        System.out.println(Validator.isChinese("中国abc")); // false
        System.out.println(Validator.isChinese("中国")); // true
        Console.log(Validator.isEmail("1565267514qq.c")); // false
    }
}
