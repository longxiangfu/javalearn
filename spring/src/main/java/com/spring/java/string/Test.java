package com.spring.java.string;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("包装");
        list.add("入仓");
        list.add("质检");
        list.add("出仓");
        list.add("拆分");
        list.add("接收");
        list.add("自采");
        for (String s : list) {
            System.out.println(s + s.hashCode());
        }
    }
}
