package com.tc.hutoolTest.http;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class HttpUtilTest {
    public static void main(String[] args) {
        /**
         请求普通页面
         */
        // get
//        String result = HttpUtil.get("https://www.baidu.com/");
//        Console.log(result);

//        String result1 = HttpUtil.get("https://www.baidu.com/", CharsetUtil.CHARSET_UTF_8);
//        Console.log(result1);

//        Map<String, Object> paramap = new HashMap<>();
//        paramap.put("city", "北京");
//        String result2 = HttpUtil.get("https://www.baidu.com/", paramap);
//        Console.log(result2);
        // post
//         Map<String, Object> paramap = new HashMap<>();
//         paramap.put("city", "北京");
//         String result3 = HttpUtil.post("https://www.baidu.com/", paramap);
//         Console.log(result3);

         /**
         文件上传
          */
//        Map<String, Object> paramap = new HashMap<>();
//        paramap.put("file", FileUtil.file("C:\\Users\\Administrator\\Desktop\\微信截图_20210218181751.png"));
//        String result4 = HttpUtil.post("https://www.baidu.com/", paramap);
//        Console.log(result4);

        /**
         * 文件下载
         */
        String fileUrl = "https://www.baidu.com/";
        HttpUtil.downloadFile(fileUrl, FileUtil.file("C:\\Users\\Administrator\\Desktop\\7.txt"), new StreamProgress() {
            @Override
            public void start() {
                Console.log("开始下载。。。");
            }

            @Override
            public void progress(long total, long progressSize) {
                Console.log("已下载：{}", FileUtil.readableFileSize(progressSize));
            }

            @Override
            public void finish() {
                Console.log("下载完成！");
            }
        });

    }
}
