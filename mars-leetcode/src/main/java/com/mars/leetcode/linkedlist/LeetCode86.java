package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

public class LeetCode86 {

    public ListNode partition(ListNode head, int x) {
        ListNode current = head;
        // 定义左侧虚拟头结点
        ListNode leftHead = new ListNode(-1);
        // 定义左侧虚拟尾节点
        ListNode leftTail = leftHead;
        // 定义右侧虚拟头结点
        ListNode rightHead = new ListNode(-1);
        // 定义右侧虚拟尾节点
        ListNode rightTail = rightHead;
        // 遍历左右节点
        while (current != null) {
            ListNode temp = current.next;
            if (current.val < x) {
                leftTail.next = current;
                leftTail = leftTail.next;
                leftTail.next = null;
            } else {
                rightTail.next = current;
                rightTail = rightTail.next;
                rightTail.next = null;
            }
            current = temp;
        }
        // 连接左右节点
        leftTail.next = rightHead.next;
        return leftHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        LeetCode86 leetCode86 = new LeetCode86();
        leetCode86.partition(node1, 3);
    }


}
