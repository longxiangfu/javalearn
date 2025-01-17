package com.tc.jdk.foundation.generic;

/**
 * 泛型  T 类型
 */
public class GenericMethod1 {

    private static <T> T add(T a, T b){
        System.out.println(a + "+" + b + "="+a+b);
        return a;
    }

    public static void main(String[] args) {
        GenericMethod1.add(1, 2); // 1+2=12
        GenericMethod1.add("a", "b"); // a+b=ab
    }

}
