package com.tc.hutoolTest.io;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.Converter;
import cn.hutool.core.io.file.FileReader;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.List;

public class FileReaderTest {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader("C:\\Users\\Administrator\\Desktop\\1.txt");
        String readString = fileReader.readString();
        System.out.println("读取的内容String：" + readString); // 读取的内容String：凄凄切切呜呜呜呜顶顶顶顶订单订单
        byte[] bytes = fileReader.readBytes();
        System.out.println("读取的内容bytes：" + bytes); // 读取的内容bytes：[B@2d56bf
        List<String> list = fileReader.readLines();
        System.out.println("读取的内容list：" + Convert.toStr(list)); // 读取的内容list：[凄凄切切呜呜呜呜顶顶顶顶订单订单]

        BufferedReader reader = fileReader.getReader();
        BufferedInputStream inputStream = fileReader.getInputStream();

    }
}
