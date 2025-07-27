package com.tc.jdk.jdk_E.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/26 11:41
 * @Version 1.0
 **/
public class LocalDateDemo {
    public static void main(String[] args) {
        //获取当前年月日
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate); // 2025-07-24
        //构建年月日   2018-01-30
        LocalDate localDate1 = LocalDate.of(2018, 01, 30);
        System.out.println(localDate1); // 2018-01-30
        //字符串转换日期
        LocalDate localDate2 = LocalDate.parse("2018-01-30");
        System.out.println(localDate2); // 2018-01-30
        //获取本月第一天
        LocalDate firstDayIfMonth = localDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayIfMonth); // 2025-07-01
        //获取本月第二天
        LocalDate secondDayOfMonth = localDate.withDayOfMonth(2);
        System.out.println(secondDayOfMonth); // 2025-07-02
        //获取本月最后一天
        LocalDate lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfMonth); // 2025-07-31
        //获取明天
        LocalDate tommrrowDay = localDate.plusDays(1);
        System.out.println(tommrrowDay); // 2025-07-25
        //获取昨天
        LocalDate yesterday = localDate.minusDays(1);
        System.out.println(yesterday); // 2025-07-23
        //获取本年第12天
        LocalDate day = localDate.withDayOfYear(12);
        System.out.println(day); // 2025-01-12
        //计算两日期之间的天数
        long days = localDate.until(localDate1, ChronoUnit.DAYS);
        System.out.println(days); // -2732
        //计算两日期之间的周数
        long weeks = localDate.until(localDate1, ChronoUnit.WEEKS);
        System.out.println(weeks); // -390

    }
}
