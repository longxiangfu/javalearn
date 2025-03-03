package com.tc.jdk.foundation.singleton;

/**
 * 双重检查锁
 * 线程安全
 * 共享资源SingletonDemo5 instance必须加上关键字volatile
 */
public class SingletonDemo5 {
//    private static volatile SingletonDemo5 instance;
    private static SingletonDemo5 instance;

    private SingletonDemo5(){};

    public static synchronized SingletonDemo5 getInstance(){
        if (instance == null){
            synchronized (SingletonDemo5.class){
                if (instance == null){
                    instance = new SingletonDemo5();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) throws InterruptedException {
        new Thread(() ->{
            while (instance == null){

            }
            System.out.println("子线程退出");
        }).start();

        Thread.sleep(1000);
        SingletonDemo5.getInstance();
        System.out.println("主线程退出");

        // 当instance不加volatile时，进程不终止
    }

}
