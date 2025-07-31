package com.tc.hutoolTest.convert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.ConverterRegistry;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 类型转换
 */
public class ConvertTest {
    public static void main(String[] args) {
        /**
        常见类型转换
         */
        // 转换为指定类型数组
//        String[] b = { "1", "2", "3", "4" };
//        Integer[] intArray = Convert.toIntArray(b);

        // 转换为日期
//        String a = "2018-05-03";
//        Date date = Convert.toDate(a);
//        System.out.println(date); // Thu May 03 00:00:00 CST 2018

        // 转换为集合
//        Object[] a = {"a", "你", "好", "", 1};
//        List list = Convert.toList(a);

        /**
         * 时间单位转换
         */
//        long a = 4535345;
//        long minutes = Convert.convertTime(a, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);
//        System.out.println(minutes); // 75


        /**
         * 以上只能实现特定类型的转换，不具备通用性
         * 利用Converter(转换器)   ConverterRegistry（转换器注册器）--里面有一些默认的转换器，也可以自定义转换器
         */
        // 默认转换器
//        ConverterRegistry converterRegistry = ConverterRegistry.getInstance();
//        String result = converterRegistry.convert(String.class, 1111);
//        System.out.println(result); // 1111

        // 自定义转换器
        ConverterRegistry converterRegistry = ConverterRegistry.getInstance();
        converterRegistry.putCustom(String.class, CustomConverter.class); // 覆盖默认的转换器
        String result = converterRegistry.convert(String.class, 4444);
        System.out.println(result); // custom:4444

    }
}
