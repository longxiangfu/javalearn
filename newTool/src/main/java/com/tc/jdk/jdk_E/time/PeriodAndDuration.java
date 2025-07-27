package com.tc.jdk.jdk_E.time;

import java.time.*;

/**
 * @Description Period:计算两个日期之间的年、月、日的差值
 * Duration:计算两时间之间的秒数，纳秒数
 * @Author Administrator
 * @DATE 2019/4/26 13:59
 * @Version 1.0
 **/
public class PeriodAndDuration {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(1990, Month.OCTOBER, 16);
        Period period = Period.between(localDate1, localDate);
        System.out.println(period.getYears()); // 34
        System.out.println(period.getMonths()); // 9
        System.out.println(period.getDays()); // 8

        LocalTime localTime = LocalTime.of(12, 12, 12);
        LocalTime localTime1 = LocalTime.of(12, 13, 27);
        Duration duration = Duration.between(localTime, localTime1);
        System.out.println(duration.getSeconds()); // 75
        System.out.println(duration.getNano()); // 0

    }
}
