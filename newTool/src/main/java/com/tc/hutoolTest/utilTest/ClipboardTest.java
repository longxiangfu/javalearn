package com.tc.hutoolTest.utilTest;

import cn.hutool.core.swing.clipboard.ClipboardUtil;
import com.sun.glass.ui.ClipboardAssistance;

import java.awt.datatransfer.Clipboard;

public class ClipboardTest {
    public static void main(String[] args) {
        // 设置内容到剪切板
        ClipboardUtil.setStr("aaaa");
        // 读取剪切板内容
        ClipboardUtil.getStr();

    }
}
