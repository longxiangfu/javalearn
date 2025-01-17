package com.tc.hutoolTest.io;

import cn.hutool.core.io.resource.ResourceUtil;

/**
 * 资源读取
 * file:/opt/test   或   /opt/test  都被当成绝对路径
 * opt/test 被当做相对路径（src/resources下）
 */
public class ResourceUtilTest {
    public static void main(String[] args) {
        String str = ResourceUtil.readUtf8Str("C:\\Users\\Administrator\\Desktop\\1.txt");
        System.out.println("绝对路径：" + str);
        System.out.println("-----------");

        String str1 = ResourceUtil.readUtf8Str("1.txt");
        System.out.println("classpath：" + str1);
    }
}
