package com.mars.leetcode.linkedlist.sum;

import com.mars.leetcode.ListNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/25 7:34 下午
 */
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1, l1);
        ListNode tail = dummy;
        int mul = 0;
        while (l1 != null || l2 != null) {
            int sum = mul;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            mul = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }
        if (mul == 1) {
            tail.next = new ListNode(1);
        }
        return dummy.next;
    }

}
