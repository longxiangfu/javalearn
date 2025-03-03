package com.tc.jdk.concurrent.cas;

import lombok.Data;

/**
 * 演示对象属性原子修改
 */
@Data
public class Counter {
    // 必须是volatile int类型，不能是Integer
    volatile int count;
    // 必须是volatile long类型，不能是Long
    volatile long count2;
    // 必须是volatile
    volatile Person person;

    public Counter(int count) {
        this.count = count;
    }
    public Counter(long count2) {
        this.count2 = count2;
    }


    @Override
    public String toString() {
        return "Counter{" +
                "count=" + count +
                ", count2=" + count2 +
                '}';
    }
}
