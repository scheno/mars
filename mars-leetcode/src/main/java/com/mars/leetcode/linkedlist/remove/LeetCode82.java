package com.mars.leetcode.linkedlist.remove;

import com.mars.leetcode.ListNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/16 5:52 下午
 */
public class LeetCode82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        // 定义虚拟头节点
        ListNode dummy = new ListNode(-1, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

}
