package com.tc.jdk.foundation.singleton;

/**
 * 双重检查锁
 * 线程安全
 */
public class SingletonDemo4 {
    private static volatile SingletonDemo4 instance;

    private SingletonDemo4(){};

    public static synchronized SingletonDemo4 getInstance(){
        if (instance == null){
            synchronized (SingletonDemo4.class){
                if (instance == null){
                    instance = new SingletonDemo4();
                }
            }
        }
        return instance;
    }

}
