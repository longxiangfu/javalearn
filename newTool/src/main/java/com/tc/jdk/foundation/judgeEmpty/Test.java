package com.tc.jdk.foundation.judgeEmpty;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 判空
 * 对象  字符串   列表   Map
 */
public class Test {
    public static void main(String[] args) throws Exception {
        // 对象
//        JudgeEntity judgeEntity = new JudgeEntity();
//        JudgeEntity judgeEntity = null;
//        if (judgeEntity == null) {
//            System.out.println("空");
//        }
//        judgeEntity = Optional.ofNullable(judgeEntity).orElseThrow(Exception::new);
//        System.out.println("judgeEntity:" + judgeEntity);

//        // 字符串
//        String str = "";
//        if (StringUtils.isBlank(str)) {
//            System.out.println("空");
//        }
//
//        // 列表 java8新特性–双括号初始化
//        List list = new ArrayList<Integer>(){{add(1); add(2);}};
//        System.out.println(CollectionUtils.isEmpty(list));
//
//        // Map  java8新特性–双括号初始化
//        Map map = new HashMap<String, Integer>(){{put("a",1); put("b", 2);}};
//        Map map = new HashMap<String, Integer>();
//        System.out.println(MapUtils.isEmpty(map));


    }
}
