package com.tc.hutoolTest.http;

import cn.hutool.core.lang.Console;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestTest {
    public static void main(String[] args) {
        /**
         * 普通表单
         */
        String url = "";
        Map<String, Object> paramap = new HashMap<>();
        String result = HttpRequest.post(url)
            .header(Header.USER_AGENT, "Hutool http")
            .form(paramap)
            .timeout(20000)
            .execute().body();
        Console.log(result);

        /**
         * restful请求
         */
        String json = "";
        HttpRequest.post(url)
                .body(json)
                .execute().body();

        /**
         * 设置代理
         */
        HttpRequest.post(url)
//                .setHttpProxy("127.0.0.1", 9089)
                .setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 9080)))
                .body(json)
                .execute().body();

    }

}
