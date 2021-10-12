package com.freedom.palindrome;

/**
 * Copyright: Copyright (c) 2021 TD
 *
 * <p> Description:
 *
 * @author liufeng
 * @version 2021/4/12 17:04
 * @since
 */
public class Node {
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public boolean isPalindrome(Node head) {
        //如果只有0个或者一个node，则直接返回
        if (head == null || head.next == null)
            return true;

        Node n1 = head;
        Node n2 = head;

        while (n2.next != null && n2.next.next != null) { // 查找中间节点
            n1 = n1.next; // n1 -> 中部
            n2 = n2.next.next; // n2 -> 尾部
        }

        n2 = n1.next; // n2 -> 右部分第一个节点

        n1.next = null; //mid.next -> null

        Node n3 = null;
        while (n2 != null) {//右半区反转
            n3 = n2.next; // n3 -> 保存下一个节点
            n2.next = n1; //下一个反转节点
            n1 = n2; //n1 移动
            n2 = n3; //n2 移动
        }
        n3 = n1; //n3-> 保存最后一个节点
        n2 = head;//n2 -> 左边第一个节点
        boolean res = true;

        while (n1 != null && n2 != null) { // 检查回文
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n3.next;// 从左部到中部
            n2 = n2.next;//从右到中部
        }
        n1 = n3.next;
        n3.next = null;

        //恢复列表
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
