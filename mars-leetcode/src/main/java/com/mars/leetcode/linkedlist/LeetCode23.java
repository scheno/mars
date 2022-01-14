package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

import java.util.PriorityQueue;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/14 12:30 上午
 */
public class LeetCode23 {

    static class Status implements Comparable<Status> {

        int val;

        ListNode node;

        public Status(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        @Override
        public int compareTo(Status status2) {
            return val - status2.val;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        PriorityQueue<Status> queue = new PriorityQueue<>();
        for (ListNode node: lists) {
            if (node != null) queue.offer(new Status(node.val, node));
        }

        while (!queue.isEmpty()) {
            Status status = queue.poll();
            tail.next = status.node;
            tail = tail.next;
            if (status.node.next != null) {
                queue.offer(new Status(status.node.next.val, status.node.next));
            }
        }

        return dummy.next;
    }
}
