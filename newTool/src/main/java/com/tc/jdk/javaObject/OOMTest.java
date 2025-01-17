package com.tc.jdk.javaObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 测试OOM
 */
public class OOMTest {

    // jvm设置: 在OOM时保存堆快照
    // -Xms5M -Xmx5M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\\workspace-lxf\\javalearn\\newTool\\target\\oom.dump
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User(Long.valueOf(i++), UUID.randomUUID().toString()));
            new User(Long.valueOf(j++), UUID.randomUUID().toString());
        }
    }
}
