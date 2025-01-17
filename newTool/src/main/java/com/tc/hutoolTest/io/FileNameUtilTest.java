package com.tc.hutoolTest.io;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;

import java.io.File;

public class FileNameUtilTest {
    public static void main(String[] args) {
        File file = FileUtil.file("C:\\Users\\Administrator\\Desktop\\1.txt");
        String name = FileNameUtil.getName(file);
        System.out.println(name); // 1.txt

        String mainName = FileNameUtil.mainName(file);
        System.out.println(mainName); // 1

        String extName = FileNameUtil.extName(file);
        System.out.println(extName); // txt

        System.out.println(FileNameUtil.getPrefix(file)); // 1
        System.out.println(FileNameUtil.getSuffix(file)); // txt

    }
}
