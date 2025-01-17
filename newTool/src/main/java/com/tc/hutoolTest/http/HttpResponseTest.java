package com.tc.hutoolTest.http;

import cn.hutool.core.lang.Console;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

public class HttpResponseTest {
    public static void main(String[] args) {
        HttpResponse response = HttpRequest.get("https://www.baidu.com/").execute();
        Console.log("http状态码：{}", response.getStatus()); // http状态码：200
        Console.log("内容编码：{}", response.contentEncoding()); // 内容编码：gzip
        Console.log("是否Gzip内容：{}", response.isGzip()); // 是否Gzip内容：true
        // 预定义的头信息
        Console.log("响应头：{}", response.header(Header.USER_AGENT)); // 响应头：null
        // 自定义的头信息
        Console.log("响应头：{}", response.header("Content-Disposition")); // 响应头：null

    }
}
