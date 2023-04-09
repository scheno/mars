package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个有序链表
 * 构建优先级队列，判断数组内部为空
 *
 * @author shenchen
 * @version 1.0
 * @date 2022/1/14 12:30 上午
 */
public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode dummy = new ListNode(0), tail = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }
}
