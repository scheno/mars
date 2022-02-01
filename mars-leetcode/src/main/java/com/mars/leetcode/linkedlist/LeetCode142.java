package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        // 解法一，将节点放入hashset，当有环时进行返回

        // 解法二，利用快慢指针，2*(a+b) = a + b + c + b
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
