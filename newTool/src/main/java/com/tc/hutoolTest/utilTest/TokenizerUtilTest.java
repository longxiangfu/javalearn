package com.tc.hutoolTest.utilTest;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.TokenizerEngine;
import cn.hutool.extra.tokenizer.TokenizerUtil;
import cn.hutool.extra.tokenizer.Word;

import java.util.Iterator;

/**
 * 中文分词
 * 门面思想：利用了java spi
 */
public class TokenizerUtilTest {
    public static void main(String[] args) {
        // 根据引入的jar来自动选择使用的引擎
        TokenizerEngine engine = TokenizerUtil.createEngine();

        // 解析
        String text = "这两个方法的区别在于返回值";
        Result result = engine.parse(text);

        Console.log(CollUtil.join((Iterator<Word>)result, "  ")); // 这  两  个  方法  的  区别  在于  返回  值
    }
}
