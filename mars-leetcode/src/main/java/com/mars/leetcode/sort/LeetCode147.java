package com.mars.leetcode.sort;

import com.mars.leetcode.ListNode;

public class LeetCode147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 虚拟头结点
        ListNode dummy = new ListNode(-1, head);
        // 记录有序序列的终点
        ListNode last = head;
        // 遍历无序队列
        ListNode after = head.next;
        while (after != null) {
            if (last.val <= after.val) {
                after = after.next;
                last = last.next;
                continue;
            }
            // 遍历有序序列，查找插入位置
            ListNode prev = dummy;
            while (prev.next.val <= after.val) {
                prev = prev.next;
            }
            // 找到插入位置
            // 删除无序节点
            last.next = after.next;
            // 插入有序队列
            after.next = prev.next;
            prev.next = after;
            // 继续移动
            after = last.next;
        }
        return dummy.next;
    }

}
