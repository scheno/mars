package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        // 定义左段链表结尾，右段链表开头，开始头结点
        ListNode leftPre, rightAfter, sonHead;
        int i = 0;
        // 查找开始头结点
        for (; i < left - 1; i++) {
            current = current.next;
        }
        // 定义左侧开始节点
        leftPre = current;
        sonHead = current.next;
        for (; i < right; i++) {
            current = current.next;
        }
        // 定义右侧开始节点
        rightAfter = current.next;
        // 断开右侧连接
        current.next = null;
        // 获取反转后头结点
        ListNode newHead = reverseList(sonHead);
        // 连接左端链表
        leftPre.next = newHead;
        // 连接右段链表
        sonHead.next = rightAfter;
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            // 获取下一个节点
            ListNode temp = current.next;
            // 将当前节点的后继节点指向前驱节点
            current.next = prev;
            // 将前驱节点指向当前节点
            prev = current;
            current = temp;
        }
        return prev;
    }

}
