package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

public class Offer52 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            if (nodeA == null) {
                nodeA = headB;
            } else {
                nodeA = nodeA.next;
            }
            if (nodeB == null) {
                nodeB = headA;
            } else {
                nodeB = nodeB.next;
            }
        }
        return nodeA;
    }

    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(0);
        ListNode nodeA2 = new ListNode(1);
        ListNode nodeB1 = new ListNode(3);
        ListNode nodeB2 = new ListNode(4);
        nodeA1.next = nodeA2;
        nodeB1.next = nodeB2;
        ListNode result = getIntersectionNode(nodeA1, nodeB1);
        System.out.println(result);
    }
}
