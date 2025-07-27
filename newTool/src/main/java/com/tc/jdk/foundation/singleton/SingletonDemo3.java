package com.tc.jdk.foundation.singleton;

/**
 * 懒汉式
 * 线程安全
 * 锁粒度太大
 */
public class SingletonDemo3 {
    private static SingletonDemo3 instance;

    private SingletonDemo3(){};

    public static synchronized SingletonDemo3 getInstance(){
        instance = new SingletonDemo3();
        return instance;
    }

}
