package com.tc.hutoolTest.utilTest;

import cn.hutool.core.swing.clipboard.ClipboardUtil;

public class ClipboardTest {
    public static void main(String[] args) {
        // 设置内容到剪切板
        ClipboardUtil.setStr("aaaa");
        // 读取剪切板内容
        ClipboardUtil.getStr();

    }
}
