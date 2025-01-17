package com.tc.hutoolTest.utilTest;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.*;

/**
 * 二维码
 */
public class QrCodeUtilTest {
    public static void main(String[] args) {
        // 生成二维码
//        QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file("C:\\Users\\Administrator\\Desktop\\qr.jpg"));

        // 自定义参数生成二维码
        QrConfig config = new QrConfig(300, 300);
        config.setMargin(3); // 二维码和背景之间的边距
        config.setForeColor(Color.CYAN); // 前景色(青色)
//        config.setBackColor(Color.GRAY);// 背景色（灰色）
        config.setImg("C:\\Users\\Administrator\\Desktop\\log.jpg"); // 设置logo图标
        // 设置纠错级别。近距离时，设置高级别，像素更高；远距离时，是指低级别，像素小
        config.setErrorCorrection(ErrorCorrectionLevel.H);
        QrCodeUtil.generate("https://hutool.cn/", config, FileUtil.file("C:\\Users\\Administrator\\Desktop\\qr.jpg"));


        // 识别二维码（前景色和背景色同时有的话识别不出）
        String decode = QrCodeUtil.decode(FileUtil.file("C:\\Users\\Administrator\\Desktop\\qr.jpg"));
        System.out.println(decode);


    }
}
