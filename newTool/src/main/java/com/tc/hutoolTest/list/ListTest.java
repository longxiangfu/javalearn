package com.tc.hutoolTest.list;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.convert.Convert;

import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = ListUtil.list(false, "1", "2", "3", "4", "3", "2", "1");
        /**
         * 查找位置
         */
//        int[] ints = ListUtil.indexOfAll(list, e -> e.equals("2"));
//        System.out.println(Convert.toStr(ints)); // [1, 5]

        /**
         * 编辑
         */
//        List<String> editList = (List<String>) CollUtil.edit(list, e ->"edit"+e);
//        System.out.println(Convert.toStr(editList)); // [edit1, edit2, edit3, edit4, edit3, edit2, edit1]


        /**
         * 列表截取
         */
//        List<String> subList = ListUtil.sub(list, 2, 4);
//        System.out.println(Convert.toStr(subList)); // [3, 4]

        /**
         * 拆分
         * size: 每段的长度
         * limit: 平均分成几段
         */
//        List<List<String>> splitList = ListUtil.split(list, 2);
//        System.out.println(Convert.toStr(splitList)); // [[1, 2], [3, 4], [3, 2], [1]]
//        List<List<String>> splitAvgList = ListUtil.splitAvg(list, 3);
//        System.out.println(Convert.toStr(splitAvgList)); // [[1, 2, 3], [4, 3], [2, 1]]

        /**
         * 按bean对象字段值进行排序
         */
//        List<TestBean> list1 = ListUtil.list(false, new TestBean(4, "4"), new TestBean(2, "2"), new TestBean(3, "3"));
//        List<TestBean> orderList = ListUtil.sortByProperty(list1, "order");
//        orderList.stream().forEach(e ->System.out.println(e.getOrder())); // 2  3  4


        /**
         * 元素交换
         */
//        ListUtil.swapTo(list, "1", 1);
//        System.out.println(Convert.toStr(list)); // [2, 1, 3, 4, 3, 2, 1]

    }
}
