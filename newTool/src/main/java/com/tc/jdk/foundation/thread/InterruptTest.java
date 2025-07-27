package com.tc.jdk.foundation.thread;

import java.io.IOException;

/**
 * Thread.interrupt():线程中断，会立刻中断，相当于java关键字break
 * System.exit(0):让整个程序中断
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        Thread interruptThread = new Thread(() -> {
            Thread currentThread = Thread.currentThread();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if(i == 10){
                    currentThread.interrupt();
//                    System.exit(0);
                }
                if(currentThread.isInterrupted()){
                    System.out.println(i + " 我中断了");
                    break;
                }else{
                    System.out.println(i+ " 我没有被中断");
                }
            }
        });
        interruptThread.start();

        System.in.read();

    }
}
