package com.tc.jdk.classLoader;

public class Math {
    public static int initData = 666;
    public int initData1 = 666;
    public static User user = new User();
    public User user1 = new User();

    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }
}
