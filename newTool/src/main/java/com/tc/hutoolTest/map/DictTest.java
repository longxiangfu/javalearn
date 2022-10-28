package com.tc.hutoolTest.map;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;

import java.util.HashMap;

/**
 * Dict继承自HashMap，但提供了更加灵活多样的使用
 */
public class DictTest {
    public static void main(String[] args) {
        Dict dict = Dict.create()
                .set("key1", 1)
                .set("key2", 1000L)
                .set("key3", DateUtil.date());

        dict.getLong("key2");
    }
}
