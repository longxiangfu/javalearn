package com.tc.jdk.classLoader;

import java.util.ArrayList;

/**
 * 测试Heap
 */
public class HeapTest {
    byte[] a = new byte[1024*100]; // 100KB

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heapTestArrayList = new ArrayList<>();
        while (true) {
            heapTestArrayList.add(new HeapTest());
            Thread.sleep(100);
        }
    }
}
