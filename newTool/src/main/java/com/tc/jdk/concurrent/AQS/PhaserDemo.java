package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.Phaser;

/**
 * Phaser:移相器：一批又一批
 * 1、register():注册新的参与者到Phaser
 * 2、arriveAndAwaitAdvance():抵达Phaser，并且等待未抵达的线程
 * 3、一个景点一个景点的参观
 * 4、每到达一个阶段就可以做一件事情，不同阶段的事情可以是不一样的；CyclicBarrier每个阶段做的事情都是一样的
 */
public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new MyPhaser();
        for (int i = 0; i < 5; i++) {
            //注册新的参与者到Phaser
            phaser.register();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() ->{
                //集合完毕发车（第一阶段完成）
                phaser.arriveAndAwaitAdvance();//线程抵达Phaser，并等待其他线程
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //景点1集合完毕发车（第二阶段完成）
                phaser.arriveAndAwaitAdvance();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //景点2集合完毕发车（第三阶段完成）
                phaser.arriveAndAwaitAdvance();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }


//        集合完毕发车
//        景点1集合完毕发车
//        景点2集合完毕发车
    }


    private static class MyPhaser extends Phaser{
        /**
         * 每个阶段完成之后的事件通知
         * @param phase  哪个阶段
         * @param registeredParties  到达当前阶段的线程数
         * @return
         */
        @Override
        protected boolean onAdvance(int phase, int registeredParties){
            boolean isTerminated = false;
            switch (phase){
                case 0 :
                    System.out.println("集合完毕发车");
                    return isTerminated;
                case 1:
                    System.out.println("景点1集合完毕发车");
                    return isTerminated;
                case 2:
                    System.out.println("景点2集合完毕发车");
                    return isTerminated;
                default:
                    return !isTerminated;
            }

        }

    }


}
