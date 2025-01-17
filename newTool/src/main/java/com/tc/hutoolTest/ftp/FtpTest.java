package com.tc.hutoolTest.ftp;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.extra.ftp.Ftp;
import cn.hutool.extra.ftp.SimpleFtpServer;
import cn.hutool.http.server.SimpleServer;

import java.io.IOException;
import java.util.List;


/**
 * ftp默认服务端口21
 * sftp默认服务端口22
 */
public class FtpTest {
    public static void main(String[] args) throws IOException {
        /**
         * 连接linux上的ftp服务
         */
//        Ftp ftp = new Ftp("43.138.16.37"); // 连接ftp服务
//        ftp.cd("/pub/file"); // cd到指定目录
////        List<String> list = ftp.ls("/"); // 查看当前目录
////        Console.log(list); // [pub]
////        ftp.upload("", FileUtil.file("C:\\Users\\Administrator\\Desktop\\erp销售出库.png")); // 上传
//        ftp.download("", "erp销售出库.png", FileUtil.file("C:\\Users\\Administrator\\Desktop\\erp销售出库1.png")); // 下载
//        ftp.close();


        /**
         * 本机（windows）开启ftp服务
         */
        SimpleFtpServer.create().addAnonymous("C:\\\\Users\\\\Administrator\\\\Desktop\\\\").start();

    }
}
