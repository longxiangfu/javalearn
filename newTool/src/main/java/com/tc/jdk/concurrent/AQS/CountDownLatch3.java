package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch:减法计数器
 * 1、countDown():计数器减1
 * 2、await():调用该方法，如果计数器不为0，则阻塞调用线程；如果等于0，则调用线程继续执行
 * 3、例子：患者排队-》医生上班-》体检-》医生下班
 * 一个线程等多个线程，多个线程等一个线程
 */
public class CountDownLatch3 {
    //分别定义医生和病人的计数器
    private static final CountDownLatch dockerLatch = new CountDownLatch(1); // 1个医生
    private static final CountDownLatch patientLatch = new CountDownLatch(5); // 5个病人
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        //患者排队
        System.out.println("患者排队");
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executorService.execute(() ->{
                try {
                    System.out.println("等待医生,病人：" + finalI);
                    //等待医生，阻塞当前线程
                    dockerLatch.await();
                    System.out.println("体检，病人：" + finalI);
                    patientLatch.countDown();//病人计数器-1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        TimeUnit.MICROSECONDS.sleep(3000);
        //医生上班
        System.out.println("医生上班");
        dockerLatch.countDown();//医生计数器-1
        //医生下班
        patientLatch.await();//等待病人体检完
        System.out.println("医生下班");
        executorService.shutdown();

//        患者排队
//        等待医生,病人：0
//        等待医生,病人：1
//        等待医生,病人：2
//        等待医生,病人：3
//        等待医生,病人：4
//        医生上班
//        体检，病人：0
//        体检，病人：2
//        体检，病人：1
//        体检，病人：4
//        体检，病人：3
//        医生下班

    }
}
