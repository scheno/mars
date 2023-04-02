package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

public class LeetCode92 {

    public ListNode reverseList(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        ListNode leftTail = dummy;
        ListNode midHead = null;
        dummy.next = head;

        ListNode prev = null;
        ListNode current = head;
        for (int i = 1; i <= right; i++) {
            ListNode temp = current.next;
            if (i < left) {
                leftTail = current;
            } else if (i == left) {
                midHead = current;
            } else {
                current.next = prev;
                prev = current;
                leftTail.next = prev;
            }
            prev = current;
            current = temp;
        }
        prev = current;
        midHead.next = current;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        LeetCode92 leetCode92 = new LeetCode92();
        leetCode92.reverseList(node1, 2, 4);
    }

}
