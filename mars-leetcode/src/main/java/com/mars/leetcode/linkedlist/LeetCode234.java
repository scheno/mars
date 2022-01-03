package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode midNode = findMid(head);
        ListNode tailNode = reverseList(midNode);
        while (tailNode != null) {
            if (tailNode.val != head.val) {
                return false;
            }
            head = head.next;
            tailNode = tailNode.next;
        }
        return true;
    }

    public ListNode findMid(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            // 获取下一个节点
            ListNode temp = current.next;
            // 将后继节点指向前驱节点
            current.next = prev;
            // 将前驱节点指向当前节点；
            prev = current;
            current = temp;
        }
        return prev;
    }

}
