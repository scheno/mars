package com.mars.leetcode.linkedlist.reverse;

import com.mars.leetcode.ListNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/19 5:20 下午
 */
public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        // 循环判断两个节点大小
        while (list1 != null && list2 != null) {
            // 如果第一个节点小于第二个节点
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        // 处理剩余节点
        if (list1 != null && list2 == null) tail.next = list1;
        if (list1 == null && list2 != null) tail.next = list2;
        return dummy.next;
    }

}
