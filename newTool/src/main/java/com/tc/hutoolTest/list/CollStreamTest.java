package com.tc.hutoolTest.list;

import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollStreamTest {
    public static void main(String[] args) {
        /**
         * 集合转map,这样后面就可以从map中取数据了
         */
//        List<Student> list = new ArrayList<>();
//        list.add(new Student(1, 1, 1, "张三"));
//        list.add(new Student(1, 1, 2, "李四"));
//        list.add(new Student(1, 1, 3, "王五"));
//        Map<Long, Student> identityMap = CollStreamUtil.toIdentityMap(list, e -> e.getStudentId());
//        System.out.println(Convert.toStr(identityMap)); // {1=com.tc.hutoolTest.list.Student@1a62a9, 2=com.tc.hutoolTest.list.Student@1b692c, 3=com.tc.hutoolTest.list.Student@1cdc67}
//        Map<Long, String> stringMap = CollStreamUtil.toMap(list, e -> e.getStudentId(), e -> e.getName());
//        System.out.println(Convert.toStr(stringMap)); // {1=张三, 2=李四, 3=王五}

        /**
         * 分组--按对象的属性分组
         */
//        List<Student> list = new ArrayList<>();
//        list.add(new Student(1, 1, 1, "张三"));
//        list.add(new Student(1, 2, 2, "李四"));
//        list.add(new Student(2, 1, 1, "擎天柱"));
//        list.add(new Student(2, 2, 2, "威震天"));
//        list.add(new Student(2, 3, 2, "霸天虎"));
//        Map<Long, List<Student>> longListMap = CollStreamUtil.groupByKey(list, e -> e.getClassId());
//        System.out.println(Convert.toStr(longListMap)); // {1=[com.tc.hutoolTest.list.Student@1a62a9, com.tc.hutoolTest.list.Student@194a155], 2=[com.tc.hutoolTest.list.Student@1b6ced, com.tc.hutoolTest.list.Student@17388c2], 3=[com.tc.hutoolTest.list.Student@252073d]}

        /**
         * 转换提取
         */
//        List<String> list1 = CollStreamUtil.toList(list, e -> e.getName());
//        System.out.println(Convert.toStr(list1)); // [张三, 李四, 擎天柱, 威震天, 霸天虎]

        /**
         * 合并
         * 两个map，key相同，则合并之后的map,还是之前的key为新key,value为自定义的规则
         */
        Map<Long, Student> map1 = new HashMap<>();
        map1.put(1L, new Student(1, 1, 1, "张三"));
        Map<Long, Student> map2 = new HashMap<>();
        map2.put(1L, new Student(2, 1, 1, "李四"));
        Map<Long, String> merge = CollStreamUtil.merge(map1, map2, (student1, student2) -> {
            if (student1 == null && student2 == null) {
                return null;
            } else if (student1 == null) {
                return student2.getName();
            } else if (student2 == null) {
                return student1.getName();
            } else {
                return student1.getName() + "," +  student2.getName();
            }
        });
        System.out.println(Convert.toStr(merge)); // {1=张三,李四}


    }


}
