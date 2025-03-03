package com.tc.jdk.foundation.singleton;

/**
 * 懒汉式
 * 线程不安全
 */
public class SingletonDemo2 {
    private static SingletonDemo2 instance;

    private SingletonDemo2(){};

    public static SingletonDemo2 getInstance(){
        return instance;
    }

}
