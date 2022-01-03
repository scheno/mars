package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

public class LeetCode328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        // 定义左侧虚拟头结点
        ListNode oddHead = new ListNode(-1);
        // 定义左侧虚拟尾节点
        ListNode oddTail = oddHead;
        // 定义右侧虚拟头结点
        ListNode evenHead = new ListNode(-1);
        // 定义右侧虚拟尾节点
        ListNode evenTail = evenHead;
        // 定义访问顺序
        int index = 1;
        // 遍历左右节点
        while (current != null) {
            ListNode temp = current.next;
            if (index % 2 == 1) {
                oddTail.next = current;
                oddTail = oddTail.next;
                oddTail.next = null;
            } else {
                evenTail.next = current;
                evenTail = evenTail.next;
                evenTail.next = null;
            }
            index++;
            current = temp;
        }
        // 连接左右节点
        oddTail.next = evenHead.next;
        return oddHead.next;
    }

}
