package com.tc.jdk.collectionDemo;


/**
 * 手动实现链表
 */
public class SimpleLinkedList {
    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();
        // 添加节点
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.print();
        // 查询节点
        System.out.println(list.find(10)); // true
        System.out.println(list.find(50)); // false
        // 删除节点
        System.out.println(list.remove(10)); // true
        list.print(); // 链表内容：20->30->40->null
        System.out.println(list.remove(50)); // false
        list.print(); // 链表内容：20->30->40->null
    }

    /**
     * 链表中的节点
     */
    static class Node {
        int data; // 节点中的值
        Node next; // 下一个节点

        public Node(int data){
            this.data = data;
        }
    }

    Node head; // 头节点

    // 空构造方法
    public SimpleLinkedList(){}

    /**
     * 末尾添加节点
     * @param data 要添加的值
     */
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }
    }

    /**
     * 移除节点
     * @param data 要移除的值
     * @return 是否移除成功
     */
    public boolean remove(int data) {
        if (head == null) {
            return false;
        }

        // 删除首节点
        if (head.data == data) {
            head = head.next;
            return true;
        }

        Node currentNode = head;
        while (currentNode.next != null && currentNode.next.data != data) {
            currentNode = currentNode.next;
        }

        // 没找到
        if (currentNode.next == null) {
            return false;
        }

        // 找到了，删除节点
        currentNode.next = currentNode.next.next;

        return true;
    }

    /**
     * 查找节点
     * @param data 要查找的值
     * @return 节点是否找到
     */
    public boolean find(int data) {
        if (head == null) {
            return false;
        }

        if (head.data == data) {
            return true;
        }

        Node currentNode = head;
        while (currentNode.next != null && currentNode.next.data != data) {
            currentNode = currentNode.next;
        }

        if (currentNode.next == null) {
            return false;
        }

        return true;
    }

    /**
     * 打印链表
     */
    public void print(){
        System.out.print("链表内容：");
        Node currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }
}
