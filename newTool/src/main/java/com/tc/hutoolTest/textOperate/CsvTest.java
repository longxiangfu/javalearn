package com.tc.hutoolTest.textOperate;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.text.csv.*;

import java.nio.charset.Charset;
import java.util.List;

public class CsvTest {
    public static void main(String[] args) {
        CsvTest csvTest = new CsvTest();
//        csvTest.write();
//        csvTest.readRow();
        csvTest.readBean();
    }

    private void write() {
        CsvWriter writer = CsvUtil.getWriter("C:\\Users\\Administrator\\Desktop\\1.csv", Charset.defaultCharset());
        writer.write(
                new String[]{"a1", "b1", "c1"},
                new String[]{"a1", "b2", "c3"},
                new String[]{"a1", "b2", "c3"}
        );
    }


    /**
     * 读取为csv数据
     */
    private void readRow() {
        CsvReader reader = CsvUtil.getReader();
        CsvData csvData = reader.read(FileUtil.file("C:\\Users\\Administrator\\Desktop\\1.csv"));
        List<CsvRow> rows = csvData.getRows();
        for (int i = 0; i < rows.size(); i++) {
            Console.log(rows.get(i).getRawList());
        }
    }


    /**
     * 读取为java bean
     */
    private void readBean() {
        CsvReader reader = CsvUtil.getReader();
        List<CsvBean> beanList = reader.read(ResourceUtil.getUtf8Reader("C:\\Users\\Administrator\\Desktop\\2.csv"), CsvBean.class);
        Console.log(beanList);
    }
}
