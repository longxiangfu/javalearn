package com.tc.jdk.concurrent.deadLock;

import lombok.Data;

@Data
public class Chopsticks {
    // 编号
    private Integer number;

    Chopsticks(Integer number) {
        this.number = number;
    }

}
