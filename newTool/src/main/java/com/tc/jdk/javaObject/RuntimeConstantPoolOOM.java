package com.tc.jdk.javaObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池的位置测试
 * 报错   OOM，java heap space      说明运行时常量池在堆中，这里指的jdk版本在1.7及以上
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 100000000; i++) {
//            for (int j = 0; j < 100000000; j++) {
//                list.add(String.valueOf(i+j/10000).intern());
//            }
//        }


        List<Integer> list = new ArrayList<>();
        for (int i = -128; i < 127; i++) {
            for (int j = -128; j < 127; j++) {

            }
        }

    }
}
