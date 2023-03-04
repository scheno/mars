package com.mars.leetcode.linkedlist.reverse;

import com.mars.leetcode.ListNode;

/**
 * 合并两个有序链表
 * 当list1小的时候尾节点指向list2，当list2小的时候尾结点指向list1
 *
 * @author shenchen
 * @version 1.0
 * @date 2022/1/19 5:20 下午
 */
public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(), tail = dummy;
        // 先处理list1和list2都不为null的情况
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            } else {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            }
        }
        // 处理 list1 为 null的情况
        if (list1 == null) {
            tail.next = list2;
        }
        // 处理 list2 为 null的情况
        if (list2 == null) {
            tail.next = list1;
        }
        return dummy.next;
    }

}
