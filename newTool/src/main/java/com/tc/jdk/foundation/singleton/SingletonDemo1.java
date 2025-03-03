package com.tc.jdk.foundation.singleton;

/**
 *饿汉式
 * 加载类时就创建了对象
 */
public class SingletonDemo1 {
    private static final SingletonDemo1 instance = new SingletonDemo1();
    private SingletonDemo1() {}

    public static SingletonDemo1 getInstance(){
        return instance;
    }
}
