package com.tc.hutoolTest.io;

import cn.hutool.core.io.file.FileWriter;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter fileWriter = new FileWriter("C:\\Users\\Administrator\\Desktop\\1.txt");
        fileWriter.write("test");
        fileWriter.append("追加");
        BufferedOutputStream outputStream = fileWriter.getOutputStream();
        PrintWriter printWriter = fileWriter.getPrintWriter(true);
        BufferedWriter writer = fileWriter.getWriter(true);
    }
}
