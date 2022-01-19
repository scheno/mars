package com.mars.leetcode.linkedlist.reverse;

import com.mars.leetcode.ListNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/19 2:02 下午
 */
public class LeetCode92 {

    // TODO 优化链表反转代码
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 定义虚拟头节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 获取左端尾节点
        ListNode leftTail = dummy;
        // 获取反转头节点
        ListNode midHead = null;

        ListNode current = head;
        ListNode pre = null;
        for (int i = 1; i <= right; i++) {
            ListNode temp = current.next;
            if (i < left) {
                leftTail = current;
            } else if (i == left) {
                midHead = current;
            } else {
                current.next = pre;
                pre = current;
            }
            current = temp;
        }
        leftTail.next = pre;
        midHead.next = current;
        return dummy.next;
    }

}
