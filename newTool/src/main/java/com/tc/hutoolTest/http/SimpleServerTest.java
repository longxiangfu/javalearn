package com.tc.hutoolTest.http;

import cn.hutool.core.net.multipart.UploadFile;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpUtil;

/**
 * SimpleServer封装了HttpUtil
 * 实现简单的Http服务处理
 */
public class SimpleServerTest {
    public static void main(String[] args) {
        // 请求
//        HttpUtil.createServer(8081)
//                .addAction("/", (req, res) -> res.write("Hello Hutool Server"))
//                .start();


        // 文件服务器
//        HttpUtil.createServer(8081)
//                .setRoot("C:\\Users\\Administrator\\Desktop")
//                .start();


        // 返回json数据
//        HttpUtil.createServer(8081)
//                .addAction("/restTest", ((request, response) -> response.write("{\"id\": 1, \"msg\": \"OK\"}", ContentType.JSON.toString())))
//                .start();


        // 文件上传
        HttpUtil.createServer(8081)
                .addAction("/file", ((request, response) -> {
                    UploadFile file = request.getMultipart().getFile("file");
                    file.write("d:/test/");
                    response.write("{\"msg\": \"OK\"}", ContentType.JSON.toString());
                }));



    }
}
