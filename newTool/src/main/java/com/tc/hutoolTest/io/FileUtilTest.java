package com.tc.hutoolTest.io;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.List;

public class FileUtilTest {
    public static void main(String[] args) {
//        FileUtil.ls()
//        FileUtil.touch()
//        FileUtil.mkdir()
//        FileUtil.del()
//        FileUtil.copy()
//        FileUtil.move();
        List<String> list = FileUtil.readUtf8Lines("C:\\\\Users\\\\Administrator\\\\Desktop\\\\1.txt");
        System.out.println(Convert.toStr(list)); // [11111111111111111]
        FileUtil.writeUtf8String("2222222222", "C:\\\\Users\\\\Administrator\\\\Desktop\\\\2.txt");


    }

}
