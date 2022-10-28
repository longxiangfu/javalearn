package com.tc.hutoolTest.date;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

/**
 * 计时器
 */
public class TimeIntervalTest {
    public static void main(String[] args) throws InterruptedException {
        TimeInterval timer = DateUtil.timer();
        Thread.sleep(3000);
        System.out.println(timer.interval()); // 3001
        System.out.println(timer.intervalSecond()); // 3
    }
}
