package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/7 10:25 下午
 */
public class LeetCode143 {

    public void reorderList(ListNode head) {
        // 寻找中间节点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 翻转后端链表
        ListNode prev = null;
        ListNode current = slow.next;
        slow.next = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        // 合并链表
        int index = 0;
        ListNode currentA = head, currentB = prev;
        while (currentA != null && currentB != null) {
            if (index++ % 2 == 0) {
                ListNode temp = currentA.next;
                currentA.next = currentB;
                currentA = temp;
            } else {
                ListNode temp = currentB.next;
                currentB.next = currentA;
                currentB = temp;
            }
        }
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
        LeetCode143 leetCode143 = new LeetCode143();
        leetCode143.reorderList(node1);
    }

}
