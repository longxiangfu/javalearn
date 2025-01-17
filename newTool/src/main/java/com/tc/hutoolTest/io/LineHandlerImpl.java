package com.tc.hutoolTest.io;

import cn.hutool.core.io.LineHandler;

public class LineHandlerImpl implements LineHandler {
    @Override
    public void handle(String line) {
        System.out.println("新增的内容：" + line);
    }
}
