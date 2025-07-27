package com.tc.jdk.foundation.singleton;

/**
 * 懒汉式
 * 线程不安全
 */
public class SingletonDemo2 {
    private static SingletonDemo2 instance;

    private SingletonDemo2(){};

    public static SingletonDemo2 getInstance(){
        instance = new SingletonDemo2();
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(SingletonDemo2.getInstance());
    }

}
