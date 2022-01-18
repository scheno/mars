package com.mars.leetcode.linkedlist.itersection;

import com.mars.leetcode.ListNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/18 7:54 下午
 */
public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        ListNode second = headB;
        while (first != null && second != null) {
            if (first == second) {
                break;
            }
            first = first.next;
            second = second.next;
            if (first == null) {
                first = headB;
                headB = null;
            }
            if (second == null) {
                second = headA;
                headA = null;
            }
        }
        return first;
    }

}
