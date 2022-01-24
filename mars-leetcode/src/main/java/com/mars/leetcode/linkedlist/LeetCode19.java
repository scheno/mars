package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

public class LeetCode19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int index = 0;
        ListNode first = head;
        ListNode dummy = new ListNode(0, head);
        ListNode second = dummy;
        while (index++ < n) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = removeNthFromEnd(node1, 2);
        System.out.println(result);
    }

}
