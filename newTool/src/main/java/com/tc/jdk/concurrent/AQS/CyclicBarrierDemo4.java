package com.tc.jdk.concurrent.AQS;

import lombok.SneakyThrows;

import java.time.LocalDate;
import java.util.TimerTask;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier:屏障。当所有线程到达屏障时，才触发一个动作
 * 1、await():表示线程到达了屏障
 * 2、例子：客车坐满，就发车
 */
public class CyclicBarrierDemo4 {
    //定义CyclicBarrier,包含3个线程，一个触发动作
    private static final CyclicBarrier barrier = new CyclicBarrier(3, () ->{
        System.out.println("发车了");
    });

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            new Thread(new MyRunnable(barrier)).start();
        }


//        乘客：Thread-2等待出发
//        乘客：Thread-3等待出发
//        乘客：Thread-4等待出发
//                发车了
//        乘客：Thread-4出发
//        乘客：Thread-3出发
//        乘客：Thread-2出发
//        乘客：Thread-5等待出发
//        乘客：Thread-6等待出发
//        乘客：Thread-7等待出发
//                发车了
//        乘客：Thread-5出发
//        乘客：Thread-6出发
//        乘客：Thread-7出发
//        乘客：Thread-8等待出发
//        乘客：Thread-9等待出发
//        乘客：Thread-10等待出发
//                发车了
//        乘客：Thread-10出发
//        乘客：Thread-8出发
//        乘客：Thread-9出发
//        乘客：Thread-11等待出发
//

    }

    private static class MyRunnable implements Runnable{
        private CyclicBarrier barrier;
        public MyRunnable(CyclicBarrier barrier){
            this.barrier = barrier;
        }

        @SneakyThrows
        @Override
        public void run() {
            System.out.println("乘客：" + Thread.currentThread().getName() + "等待出发");
            barrier.await();//表示当前线程到达了屏障
            System.out.println("乘客：" + Thread.currentThread().getName() + "出发");
        }
    }

}
