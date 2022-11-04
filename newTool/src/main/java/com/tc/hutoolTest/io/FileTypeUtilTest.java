package com.tc.hutoolTest.io;

import cn.hutool.core.io.FileTypeUtil;

/**
 * 过读取文件的首部几个二进制位来判断常用的文件类型
 */
public class FileTypeUtilTest {
    public static void main(String[] args) {
        String typeByPath = FileTypeUtil.getTypeByPath("C:\\\\Users\\\\Administrator\\\\Desktop\\\\1.txt");
        System.out.println(typeByPath); // txt
        String typeByPath1 = FileTypeUtil.getTypeByPath("G:\\新发地生鲜\\基础erp接口中间表_v3.2.xlsx");
        System.out.println(typeByPath1); // xlsx
    }
}
