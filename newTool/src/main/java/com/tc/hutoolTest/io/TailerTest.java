package com.tc.hutoolTest.io;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.Tailer;

/**
 * Tailer  文件内容有新增时，打印出新增内容到控制台或者进行别的操作
 */
public class TailerTest {
    public static void main(String[] args) throws InterruptedException {
//        Tailer tailer = new Tailer(FileUtil.file("C:\\Users\\Administrator\\Desktop\\1.txt"), Tailer.CONSOLE_HANDLER, 2);
//        tailer.start();

        Tailer tailer = new Tailer(FileUtil.file("C:\\Users\\Administrator\\Desktop\\1.txt"), new LineHandlerImpl(), 2);
        tailer.start();

        Thread.sleep(10000);
    }
}
