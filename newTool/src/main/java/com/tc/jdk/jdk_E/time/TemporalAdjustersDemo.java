package com.tc.jdk.jdk_E.time;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * @Description
 * @Author Administrator
 * @DATE 2019/4/26 13:51
 * @Version 1.0
 **/
public class TemporalAdjustersDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfMonth())); // 2025-07-01
        System.out.println(localDate.with(TemporalAdjusters.lastDayOfMonth())); // 2025-07-31
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfYear())); // 2025-01-01
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfNextMonth())); // 2025-08-01
    }
}
