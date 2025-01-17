package com.tc.hutoolTest.io;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileAppender;

import java.io.File;

/**
 * 支持缓存的文件追加器
 * 不需要关闭，在写入结束后自动关闭
 */
public class FileAppenderTest {
    public static void main(String[] args) {
        File file = FileUtil.file("C:\\Users\\Administrator\\Desktop\\1.txt");
        FileAppender fileAppender = new FileAppender(file, 16, true);
        fileAppender.append("123");
        fileAppender.append("1ddd23");
        fileAppender.append("123qq");
        fileAppender.flush();
    }
}
