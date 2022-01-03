package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

public class Offer22 {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode preNode = head, afterNode = head;
        int step = 0;
        while (preNode != null) {
            preNode = preNode.next;
            step++;
            if (step > k + 1) {
                afterNode = afterNode.next;
            }
        }
        return afterNode;
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
        ListNode result = getKthFromEnd(node1, 2);
        System.out.println(result);
    }
}
