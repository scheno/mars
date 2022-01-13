package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

/**
 * @author shenchen
 * @date 2022/1/13 10:56 下午
 * @version 1.0
 */
public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 创建虚拟头节点
        ListNode dummy = new ListNode();
        // 当前节点
        ListNode current = head;
        // 需要反转的头节点
        ListNode preHead = current;
        // 反转之前的头节点
        ListNode preTail = dummy;
        // 下一个需要反转的头节点
        ListNode nextHead = null;
        // 处理链表
        while (current != null) {
            int i = 0;
            // k个一组，寻找下一个节点
            for (; i < k; i++) {
                // 是否存在下一个需要反转的头节点
                if (current != null) {
                    current = current.next;
                } else {
                    break;
                }
            }
            // 如果满足k个节点，进行反转
            if (i == k) {
                nextHead = current;
                preTail.next = reverse(preHead, k);
                preTail = preHead;
                preHead = nextHead;
            } else {
                // 处理剩下节点
                preTail.next = nextHead;
            }
        }
        // 先找到下一个开始的头节点，如果存在，则进行链表反转
        // 反转链表，保存反转前的的尾指针，将反转前的链表的尾指针设置下一个反转
        return dummy.next;
    }

    public ListNode reverse(ListNode head, int k) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode current = head;
        int index = 0;
        // 从头节点开始，反转k个链表
        while (index++ < k) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
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

        LeetCode25 leetCode25 = new LeetCode25();
        ListNode node = leetCode25.reverseKGroup(node1, 2);
    }
}
