package com.tc.hutoolTest.utilTest;

import cn.hutool.core.util.RuntimeUtil;

public class RuntimeTest {
    public static void main(String[] args) {
        // 获取网卡信息
        System.out.println(RuntimeUtil.execForStr("ipconfig"));
    }
}
