package com.tc.hutoolTest.cglib;

import cn.hutool.extra.cglib.CglibUtil;

/**
 * cglib：动态代理  Bean复制
 */
public class CglibUtilTest {
    public static void main(String[] args) {
        SimpleBean simpleBean = new SimpleBean();
        simpleBean.setValue("hello world");

        OtherSimpleBean copy = CglibUtil.copy(simpleBean, OtherSimpleBean.class);
        System.out.println(copy); // OtherSimpleBean(value=hello world)
    }
}
