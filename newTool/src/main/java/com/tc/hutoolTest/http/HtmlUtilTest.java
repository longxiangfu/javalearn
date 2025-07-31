package com.tc.hutoolTest.http;

import cn.hutool.core.lang.Console;
import cn.hutool.http.HtmlUtil;

/**
 * HtmlUtil 操作html
 */
public class HtmlUtilTest {
    public static void main(String[] args) {
        /**
         * 转义HTML特殊字符，包括：
         * ' 替换为 &#039;
         * " 替换为 &quot;
         * & 替换为 &amp;
         * < 替换为 &lt;
         * > 替换为 &gt;
         */
//        String html = "<html><body>123'123'</body></html>";
//        Console.log(HtmlUtil.escape(html)); // &lt;html&gt;&lt;body&gt;123&#039;123&#039;&lt;/body&gt;&lt;/html&gt;

        /**
         * 还原被转义的HTML特殊字符
         */
//        String escape = "&lt;html&gt;&lt;body&gt;123&#039;123&#039;&lt;/body&gt;&lt;/html&gt;";
//        Console.log(HtmlUtil.unescape(escape)); // <html><body>123'123'</body></html>

        /**
         * 移除指定HTML标签和被标签包围的内容
         */
//        String str = "pre<img src=\"xxx/dfdsfds/test.jpg\">";
//        Console.log(HtmlUtil.removeHtmlTag(str, "img")); // pre

        /**
         * 清除所有HTML标签，但是保留标签内的内容
         */
//        String str = "pre<div class=\"test_div\">\r\n\t\tdfdsfdsfdsf\r\n</div><div class=\"test_div\">BBBB</div>";
//        Console.log(HtmlUtil.cleanHtmlTag(str)); // pre\r\n\t\tdfdsfdsfdsf\r\nBBBB

        /**
         * 清除指定HTML标签，不包括内容
         */
//        String str = "pre<div class=\"test_div\">abc</div>";
//        Console.log(HtmlUtil.unwrapHtmlTag(str, "div")); // preabc

        /**
         * 去除HTML标签中的指定属性，如果多个标签有相同属性，都去除
         */
//        String html = "<div class=\"test_div\"></div><span class=\"test_div\"></span>";
//        Console.log(HtmlUtil.removeHtmlAttr(html, "class")); // <div></div><span></span>

        /**
         * 去除指定标签的所有属性
         */
//        String html = "<div class=\"test_div\" width=\"120\"></div>";
//        Console.log(HtmlUtil.removeAllHtmlAttr(html, "div")); // <div></div>

        /**
         * 过滤HTML文本，防止XSS攻击
         */
        String html = "per<alert></alert>";
        Console.log(HtmlUtil.filter(html)); // per
    }

}
