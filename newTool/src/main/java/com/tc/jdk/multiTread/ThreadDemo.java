package com.tc.jdk.multiTread;

/**
 * 在断点调试的时候，我们可以通过点击idea debug窗口中红色箭头指向的相机图标，获取当前线程的dump信息。
 * 这个功能有什么用呢？我们可以通过线程名，分析当前是哪个线程执行的，在多线程环境下对代码运行分析起到辅助作用。
 * 比如下图1， run()方法是通过main主线程执行的，只是方法调用，并没有启动多线程（这是我们熟知结论的实践证明）
 */
public class ThreadDemo extends Thread {

    public void run() {
        System.out.println("执行");
    }

    public static void main(String[] args) {
        new ThreadDemo().run(); // 调用当前线程的run方法，并没有产生新的线程
//        new ThreadDemo().start(); // 产生了新的线程
    }
}
