package com.tc.jdk.foundation.algorithm.algotithm;

/**
 * 链表反转
 * 迭代：一个元素一个元素进行处理,处理每一个元素时都需要改变一些中间状态，直到处理到最后一个元素
 * 递归：将大问题（整个链表的反转）转成性质相同的小问题（每两个元素之间的反转）
 */
public class LianBiaoFanZhuan {
    // 链表节点
    static class ListNode{
        // 节点值
        int val;
        // 下一个节点
        ListNode next;

        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * 迭代
     * @param head 反转前的头节点
     * @return 反转后的头节点
     */
    public static ListNode iterate(ListNode head) {
        ListNode curr = head; // 当前节点
        ListNode pre = null; // 上一个节点
        ListNode next; // 下一个节点
        while (curr != null){
            next = curr.next; // 保存下一个节点到变量
            curr.next = pre; // next指针指向上一个节点
            // 当前节点反转完成需要做的事情
            pre = curr; // 修改上一个节点为当前节点
            curr = next; // 修改当前节点为下一个节点
        }

        return pre;
    }


    /**
     * 递归
     * @param head 反转前的头节点
     * @return 反转后的头节点
     */
    public static ListNode recursion(ListNode head){
        // 本身节点就是null,直接返回
        // 或找到了最后一个节点，不用翻转，直接返回最后一个节点
        if (head == null || head.next == null) {
            return head;
        }

        // 递归找到最后一个节点，从最后一个节点开始处理
        ListNode newNode = recursion(head.next);

        // 算法（从倒数第二个开始）
        head.next.next = head;
        head.next = null;

        return newNode;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
//        ListNode listNode = iterate(listNode1);
        ListNode listNode = recursion(listNode1);
        System.out.println(listNode);
    }
}
