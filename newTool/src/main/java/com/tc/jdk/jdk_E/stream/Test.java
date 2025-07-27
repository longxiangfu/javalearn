package com.tc.jdk.jdk_E.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String[] arr = {
            "apple", "orange", "pear", "banana", "apple", "orange", "pear",
        };
        Map<String, Long> map = Arrays.stream(arr).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
//        banana:1
//        orange:2
//        apple:2
//        pear:2
    }
}
