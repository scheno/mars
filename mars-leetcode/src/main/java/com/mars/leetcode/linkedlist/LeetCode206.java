package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            // 保存下一个节点
            ListNode temp = current.next;
            // 修改当前节点后继指向
            current.next = prev;
            // 修改前驱节点
            prev = current;
            current = temp;
        }
        return prev;
    }

}
