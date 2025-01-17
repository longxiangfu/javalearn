package com.tc.hutoolTest.utilTest;

import cn.hutool.core.lang.Console;
import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.util.CharsetUtil;

/**
 * UrlBuilder 构建和接续url
 * 相比jdk中URL更方便
 */
public class UrlBuilderTest {
    public static void main(String[] args) {
        String buildUrl = UrlBuilder.of()
                .setScheme("https")
                .setHost("www.hutool.cn")
                .addPath("/aaa").addPath("bbb")
                .addQuery("ie", "utf-8")
                .addQuery("wd", "test")
                .build();
        Console.log(buildUrl); // https://www.hutool.cn/aaa/bbb?ie=utf-8&wd=test


        UrlBuilder urlBuilder = UrlBuilder.ofHttp("www.hutool.cn/aaa/bbb/?a=张三&b=%e6%9d%8e%e5%9b%9b#frag1", CharsetUtil.CHARSET_UTF_8);
        Console.log(urlBuilder.getQuery().get("a")); // 张三
        Console.log(urlBuilder.getQuery().get("b")); // 李四


        String urlStr = "https://mp.weixin.qq.com/s?__biz=MzI5NjkyNTIxMg==&amp;mid=100000465&amp;idx=1";
        UrlBuilder builder = UrlBuilder.ofHttp(urlStr, CharsetUtil.CHARSET_UTF_8);
        Console.log(builder.build()); // https://mp.weixin.qq.com/s?__biz=MzI5NjkyNTIxMg==&mid=100000465&idx=1
    }
}
