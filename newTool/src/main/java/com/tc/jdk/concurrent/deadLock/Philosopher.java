package com.tc.jdk.concurrent.deadLock;

import lombok.Data;

/**
 * 哲学家
 */
@Data
public class Philosopher extends Thread {
    // 左手边筷子
    private Chopsticks left;
    // 右手边筷子
    private Chopsticks right;

    Philosopher(String name, Chopsticks left, Chopsticks right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    void eat() {
        System.out.println(super.getName() + "开始吃");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void think() {
        System.out.println(super.getName() + "开始思考");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized(left) {
                System.out.println(super.getName() + "获取到左手边筷子" + left.getNumber());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(right) {
                    System.out.println(super.getName() + "获取到右手边筷子" + right.getNumber());
                    eat();
                }
            }
            System.out.println("吃完了，把筷子放回原处");
            think();

        }
    }
}
