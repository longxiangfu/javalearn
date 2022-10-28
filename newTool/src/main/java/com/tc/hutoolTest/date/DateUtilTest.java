package com.tc.hutoolTest.date;

import cn.hutool.core.date.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtilTest {
    public static void main(String[] args) {
        /**
         * 当前时间
         */
//        System.out.println(DateUtil.date()); // 2022-10-21 15:11:29

        /**
         * 字符串转日期
         */
//        String dateStr = "2017-03-01 10:56:25";
//        System.out.println(DateUtil.parse(dateStr, "yyyy-MM-dd HH:mm:ss")); // 2017-03-01 10:56:25

        /**
         * 日期格式化
         */
//        Date date = DateUtil.date();
//        System.out.println(date); // 2022-10-21 15:10:50
//        System.out.println(DateUtil.format(date, "yyyy/MM/dd")); // 2022/10/21
//        System.out.println(DateUtil.formatDate(date)); // 2022-10-21
//        System.out.println(DateUtil.formatDateTime(date)); // 2022-10-21 15:09:56
//        System.out.println(DateUtil.formatTime(date)); /// 15:09:56

        /**
         * 获取Date对象的某一部分
         */
//        DateTime date = DateUtil.date();
//        System.out.println(DateUtil.year(date)); // 2022
//        System.out.println(DateUtil.month(date)); // 9
//        System.out.println(DateUtil.monthEnum(date));// OCTOBER

        /**
         * 开始和结束时间
         */
//        DateTime date = DateUtil.date();
//        System.out.println(DateUtil.beginOfDay(date)); // 2022-10-21 00:00:00
//        System.out.println(DateUtil.endOfDay(date)); // 2022-10-21 23:59:59

        /**
         * 日期时间偏移
         */
//        DateTime date = DateUtil.date();
//        System.out.println(date); // 2022-10-21 16:02:48
//        System.out.println(DateUtil.offset(date, DateField.DAY_OF_MONTH, 2)); // 2022-10-23 16:02:48
//        System.out.println(DateUtil.offsetDay(date, 2)); // 2022-10-23 16:02:48
//        System.out.println(DateUtil.offsetHour(date, -3)); // 2022-10-21 13:02:48
//        System.out.println(DateUtil.yesterday()); // 2022-10-20 16:05:51
//        System.out.println(DateUtil.tomorrow()); // 2022-10-22 16:05:51
//        System.out.println(DateUtil.lastWeek()); // 2022-10-14 16:05:51
//        System.out.println(DateUtil.nextWeek()); // 2022-10-28 16:05:51
//        System.out.println(DateUtil.lastMonth()); // 2022-09-21 16:05:51
//        System.out.println(DateUtil.nextMonth()); // 2022-11-21 16:05:51


        /**
         * 日期时间差
         */
//        String dateStr1 = "2017-03-01 22:33:23";
//        Date date1 = DateUtil.parse(dateStr1);
//        String dateStr2 = "2017-04-01 21:39:20";
//        Date date2 = DateUtil.parse(dateStr2);
//        long between = DateUtil.between(date2, date1, DateUnit.DAY);
//        System.out.println(between); // 30


        /**
         * 星座和属性
         */
//        System.out.println(DateUtil.getZodiac(Month.JANUARY.getValue(), 19)); // 摩羯座
//        System.out.println(DateUtil.getChineseZodiac(1994)); // 狗

        /**
         * 其他。年龄，是否是闰年
         */
        System.out.println(DateUtil.ageOfNow("1990-01-03")); // 32
        System.out.println(DateUtil.isLeapYear(2013)); // false


    }
}
