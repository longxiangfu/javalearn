package com.tc.jdk.javaObject;

/**
 * 演示cpu飚高
 * 使用jstack解决问题
 */
public class Math {
    public static int initData = 666;
    public int initData1 = 666;

    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        while (true) {
//            math.compute();
        }
    }
}
