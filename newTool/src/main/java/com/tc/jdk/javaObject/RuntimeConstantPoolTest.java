package com.tc.jdk.javaObject;

/**
 * 运行时常量池若干例子
 * 字符串常量池
 */
public class RuntimeConstantPoolTest {
    public static void main(String[] args) {
//        String a = new String("abc");
//        String a1 = a.intern();
//        System.out.println(a == a1); // false

//        String s1 = new String("he") + new String("llo");
//        String s2 = s1.intern();
//        System.out.println(s1 == s2); // true

//        String s0 = "zhuge";
//        String s1 = "zhuge";
//        String s2 = "zhu" + "ge";
//        System.out.println(s0 == s1); // true
//        System.out.println(s2 == s1); //

//        String s0 = "zhuge";
//        String s1 = new String("zhuge");
//        String s2 = "zhu" + new String("ge");
//        System.out.println(s0 == s1); // false
//        System.out.println(s0 == s2); // false
//        System.out.println(s1 == s2); // false

//        String s = "a" + "b" + "c";
//        String a = "a";
//        String b = "b";
//        String c = "c";
//        String s1 = a + b + c;
//        System.out.println(s == s1); // false

//        // 注意，在字符串常量池中肯定有"java"这样的字面量，因为"java"是关键字
//        String str = new StringBuilder("计算机").append("技术").toString(); // 会new String，但是没有字面量"计算机技术"
//        System.out.println(str == str.intern()); // true
//        String str1 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str1 == str1.intern()); // false


        // "abc"是字面量
        String s = new StringBuilder("abc").toString(); // 会new String
        System.out.println(s == s.intern()); // false

    }
}
