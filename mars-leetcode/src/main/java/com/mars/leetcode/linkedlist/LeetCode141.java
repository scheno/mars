package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

/**
 * 环形链表
 * 利用快慢指针，如果链表有环，快慢指针终将相遇
 */
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        // 如果是空或者单节点，说明不可能存在环形链表
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        // 如果快节点和快节点的下一个节点不为空，则继续判断
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
