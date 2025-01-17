package com.tc.hutoolTest.http;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;

import java.util.List;


/**
 * 爬虫
 * 也可以使用Jsonp
 */
public class PaChong {
    public static void main(String[] args) {
        // 请求
        String listContent = HttpUtil.get("https://www.oschina.net/news/widgets/_news_index_all_list_new?p=5&type=ajax");
        // 使用正则获取所有包含标题的内容
        // (.*?)表示我们需要的内容，.表示任意字符，*表示0个或多个，?表示最短匹配
        List<String> titles = ReUtil.findAll("<div class=\"title\"(.*?)</div>", listContent, 1);
        for (String title :
                titles) {
            String filterTitle = StrUtil.sub(title, title.lastIndexOf(">") + 1, title.length());
            if (!"精彩评论".equals(filterTitle)) {
                System.out.println(filterTitle.trim());
            }

        }
    }

}
