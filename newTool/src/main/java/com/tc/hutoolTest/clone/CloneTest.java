package com.tc.hutoolTest.clone;

import cn.hutool.core.util.ObjectUtil;

public class CloneTest {
    public static void main(String[] args) {
        /**
        浅克隆根据jdk的方法
         */

        /**
        深克隆，hutool对jdk进行了封装
         */
        ObjectUtil.cloneByStream(null);
    }
}
