package com.tc.hutoolTest.io;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import sun.nio.ch.IOUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;

/**
 * IoUtil：操作字节流和字符流
 */
public class IOUtilTest {
    public static void main(String[] args) {
        /**
         * 拷贝
         * InputStream、OutputStream  字节流
         */
//        BufferedInputStream inputStream = FileUtil.getInputStream("C:\\Users\\Administrator\\Desktop\\1.txt");
//        BufferedOutputStream outputStream = FileUtil.getOutputStream("C:\\Users\\Administrator\\Desktop\\2.txt");
//        IoUtil.copy(inputStream, outputStream, IoUtil.DEFAULT_BUFFER_SIZE);
//        IoUtil.close(inputStream);
//        IoUtil.close(outputStream);

        /**
         * Reader、Writer  字符流
         */
//        BufferedInputStream inputStream = FileUtil.getInputStream("C:\\Users\\Administrator\\Desktop\\1.txt");
//        BufferedOutputStream outputStream = FileUtil.getOutputStream("C:\\Users\\Administrator\\Desktop\\2.txt");
//        BufferedReader utf8Reader = IoUtil.getUtf8Reader(inputStream);
//        OutputStreamWriter utf8Writer = IoUtil.getUtf8Writer(outputStream);
//        IoUtil.copy(utf8Reader, utf8Writer);
//        IoUtil.close(inputStream);
//        IoUtil.close(outputStream);
//        IoUtil.close(utf8Reader);
//        IoUtil.close(utf8Writer);

        /**
         * 读入
         */
//        IoUtil.read()
//        IoUtil.toStream() // 将某些对象转成流对象
//        IoUtil.readHex() // 读取十六进制字符串

        /**
         * 写出
         */
//        IoUtil.write();

    }


}
