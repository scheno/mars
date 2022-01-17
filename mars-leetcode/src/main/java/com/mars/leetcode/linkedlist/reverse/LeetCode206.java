package com.mars.leetcode.linkedlist.reverse;

import com.mars.leetcode.ListNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/17 11:58 上午
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) { return null; }
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }
}
