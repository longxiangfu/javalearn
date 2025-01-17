package com.tc.hutoolTest.utilTest;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.setting.Setting;
import cn.hutool.setting.dialect.Props;

/**
 * 代替jdk中的Properties
 * value可以使用中文,Properties不能
 */
public class SettingTest {
    public static void main(String[] args) {
        // 读取配置文件
        Setting setting = new Setting(FileUtil.touch("example.setting"), CharsetUtil.CHARSET_UTF_8, true);

       // "我的名字"  // 读取配置参数
        String str = setting.getStr("user", "demo", "myUser");
        Console.log(str); // rootcom.mysql.jdbc.Driver
        String name = setting.getStr("name", "demo", "myName");
        Console.log(name);

        // 配置文件变更时自动加载
//        setting.autoLoad(true); // 阻塞方法，监听配置文件变化

        // 还可以将配置映射成对象
//        UserVO userVo = new UserVo();
//        setting.toBean(userVo);


        /**
         * Props extends Properties
         * 使用更方便，使用同Setting，但是不能使用变量
         */
        Props props = new Props("example.properties", CharsetUtil.CHARSET_UTF_8);
        System.out.println(props.getProperty("user")); // root${demo.driver}   --不能使用变量
        System.out.println(props.getStr("name")); // "我的名字"


    }
}
