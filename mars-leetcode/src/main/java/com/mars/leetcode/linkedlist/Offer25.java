package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

public class Offer25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 定义虚拟头结点
        ListNode dummy = new ListNode(-1);
        // 定义尾节点
        ListNode tail = dummy;
        // 循环遍历两个链表
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            // 移动尾部节点
            tail = tail.next;
            // 断开尾部节点连接
            tail.next = null;
        }
        // 处理另一个链表
        tail.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

}
