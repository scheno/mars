package com.mars.leetcode.linkedlist.itersection;

import com.mars.leetcode.ListNode;

/**
 * 相交链表
 * 长度分别为 a、b、c
 * 那 a + c + b = b + c + a
 *
 *
 * @author shenchen
 * @version 1.0
 * @date 2022/1/18 7:54 下午
 */
public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        ListNode second = headB;
        while (first != null && second != null) {
            // 如果节点形同，则直接返回
            if (first == second) {
                break;
            }
            // 分别指向下一个节点
            first = first.next;
            second = second.next;
            // 如果第一个遍历完则指向另外一个
            if (first == null) {
                first = headB;
                // 将另一个置为空，防止出现死循环
                headB = null;
            }
            // 如果第一个遍历完则指向另外一个
            if (second == null) {
                second = headA;
                // 将另一个置为空，防止出现死循环
                headA = null;
            }
        }
        return first;
    }

}
