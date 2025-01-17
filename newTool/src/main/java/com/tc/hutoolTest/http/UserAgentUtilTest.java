package com.tc.hutoolTest.http;

import cn.hutool.core.lang.Console;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;

public class UserAgentUtilTest {
    public static void main(String[] args) {
        String uaStr = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.835.163 Safari/535.1";
        UserAgent userAgent = UserAgentUtil.parse(uaStr);
        // 浏览器
        Console.log(userAgent.getBrowser().toString()); // Chrome
        // 浏览器版本
        Console.log(userAgent.getVersion()); // 14.0.835.163
        // 浏览器渲染引擎
        Console.log(userAgent.getEngine().toString()); // Webkit
        // 浏览器渲染引擎版本
        Console.log(userAgent.getEngineVersion()); // 535.1
        // 操作系统
        Console.log(userAgent.getOs().toString()); // Windows 7 or Windows Server 2008R2
        // 平台类型
        Console.log(userAgent.getPlatform()); // Windows
        // 是否是移动终端
        Console.log(userAgent.isMobile()); // false
    }
}
