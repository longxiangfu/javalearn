package com.tc.hutoolTest.list;

import cn.hutool.core.collection.BoundedPriorityQueue;

/**
 * 有界（容量一定）优先（排序）队列
 */
public class BoundedPriorityQueueTest {
    public static void main(String[] args) {
        // 需求：名字被hash到不到的数据库，现在要求查出最热门的5个，如何做？
        // 传统的做法:从每个数据中取出前5个，放到一个集合中，再做排序，最后取前5个
        // 现在的做法：从每个数据中取出前5个，放到BoundedPriorityQueue中，有界优先队列自己有容量限制和排序

        // 设定容量,内部比较器按从小到大排序(也可以自定义比较器)
        BoundedPriorityQueue<Integer> boundedPriorityQueue = new BoundedPriorityQueue(5);
        int[] array = new int[]{3, 7, 99, 2, 39, 6};
        for (int i :
                array) {
            boundedPriorityQueue.offer(i);
        }
        System.out.println(boundedPriorityQueue); // [2, 3, 6, 7, 39]

    }
}
