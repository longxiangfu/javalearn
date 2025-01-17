package com.tc.hutoolTest.textOperate;

import cn.hutool.core.lang.Console;
import cn.hutool.core.text.StrSplitter;

import java.util.List;

/**
 * StrSplitter相比String的split更丰富
 */
public class StrSplitterTest {
    public static void main(String[] args) {
        String str = "a, ,efedsfs,   ddf";
        List<String> split = StrSplitter.split(str, ",", 0, true, true);
        Console.log(split); // [a, efedsfs, ddf]
    }
}
