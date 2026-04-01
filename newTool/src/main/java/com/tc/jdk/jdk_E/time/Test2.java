package com.tc.jdk.jdk_E.time;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Data和LocalDate之间的转换
 */
public class Test2 {
    public static void main(String[] args) {
        // 1. Date -> LocalDate
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.printf("date:%s, localDate:%s%n", date, localDate); // date:Wed Apr 01 13:26:28 CST 2026, localDate:2026-04-01
        
        // 2. LocalDate -> Date
        LocalDate localDate1 = LocalDate.now();
        Date date1 = Date.from(localDate1.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        System.out.printf("localDate1:%s, date1:%s%n", localDate1, date1); // localDate1:2026-04-01, date1:Wed Apr 01 00:00:00 CST 2026
    }
}
