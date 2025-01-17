package com.tc.jdk.concurrent.deadLock;

import lombok.Data;
import lombok.Synchronized;

/**
 * 死锁
 * 哲学家就餐问题
 * 打破循环
 */
@Data
public class Test2 {
    public static void main(String[] args) {
        Chopsticks c1 = new Chopsticks(1);
        Chopsticks c2 = new Chopsticks(2);
        Chopsticks c3 = new Chopsticks(3);
        Chopsticks c4 = new Chopsticks(4);
        Chopsticks c5 = new Chopsticks(5);

        new Philosopher("哲学家1,", c1, c2).start();
        new Philosopher("哲学家2,", c2, c3).start();
        new Philosopher("哲学家3,", c3, c4).start();
        new Philosopher("哲学家4,", c4, c5).start();
//        new Philosopher("哲学家5,", c5, c1).start();
        new Philosopher("哲学家5,", c1, c5).start(); // 打破循环

    }
}
