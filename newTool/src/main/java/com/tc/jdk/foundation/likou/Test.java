package com.tc.jdk.foundation.likou;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/**
 * merge(): 将相同key的value进行合并
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map.merge(a, b, (v1, v2)->v1+v2);
        }

        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
