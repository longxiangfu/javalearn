package com.tc.jdk.foundation.string;

/**
 * charAt()
 * 如果返回使用char接收，则接收的是字符
 * 如果返回使用int接收，则接收的是字符的ASCII码
 */
public class StringTest1 {
    public static void main(String[] args) {

        char b = "A".charAt(0);
        System.out.println(b); // A

        int c = "A".charAt(0);
        System.out.println(c); // 65




    }
}
