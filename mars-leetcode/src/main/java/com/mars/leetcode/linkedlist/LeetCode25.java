package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

/**
 * K个一组反转链表
 * 采用递归+头插法，从后往前寻找第K个长度链表的head，
 * 然后利用头插法局部链表翻转，最终完成所有链表翻转
 *
 * @author shenchen
 * @date 2022/1/13 10:56 下午
 * @version 1.0
 */
public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        // 判断从head起，链表长度是否达到k
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                // 如果没有k个节点，不做翻转，直接返回
                return head;
            }
            temp = temp.next;
        }
        // 递归调用，获取最后一个头结点
        ListNode prev = reverseKGroup(temp, k);
        for (int i = 0; i < k; i++) {
            // 获取head节点的下一个节点
            temp = head.next;
            // 将head节点指向上一次递归返回的头结点（可能是反转的，也可能是未翻转的，也可能是空）
            head.next = prev;
            // 前移prev节点
            prev = head;
            // 后移head节点
            head = temp;
        }
        // 返回头节点
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
        System.out.println(node);
    }
}
