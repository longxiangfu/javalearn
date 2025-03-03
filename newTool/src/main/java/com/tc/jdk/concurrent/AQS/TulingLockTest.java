package com.tc.jdk.concurrent.AQS;

/**
 * 自定义锁测试
 */
public class TulingLockTest {
    // volatile只能保证可见性有序性，不能保证线程安全。
    private volatile static int sum = 0;
    private static TulingLock tulingLock = new TulingLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() ->{
                tulingLock.lock();
                try{
                    for (int j = 0; j < 10000; j++) {
                        sum++;
                    }

                } finally {
                    tulingLock.unlock();
                }

            });
            thread.start();
        }

        Thread.sleep(3000);
        System.out.println(sum);
    }
}
