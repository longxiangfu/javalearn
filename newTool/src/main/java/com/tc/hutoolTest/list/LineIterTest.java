package com.tc.hutoolTest.list;

import cn.hutool.core.collection.LineIter;
import cn.hutool.core.io.resource.ResourceUtil;

public class LineIterTest {
    public static void main(String[] args) {
        /**
         * 行遍历器
         */
        LineIter lineIter = new LineIter(ResourceUtil.getUtf8Reader("D:\\workspace-lxf\\javalearn\\newTool\\src\\main\\java\\com\\tc\\hutoolTest\\list\\read.txt"));
        for (String str :
                lineIter) {
            System.out.println(str);
        }

    }
}
