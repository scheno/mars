package com.mars.leetcode.linkedlist;

import com.mars.leetcode.ListNode;

public class Interview02_05 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //新链表
        ListNode newNode = new ListNode(-1);
        //新链表头
        ListNode newHead = newNode;
        //用来保存进制位
        int carry = 0;
        while (l1 != null || l2 != null) {
            //判断当前位是否为空，为空则设置为0
            int l1Num = l1 == null ? 0 : l1.val;
            int l2Num = l2 == null ? 0 : l2.val;
            //求和
            int sum = l1Num + l2Num + carry;
            //更新进位
            carry = sum / 10;
            //求节点值
            int nodeNum = sum % 10;
            //添加节点
            newNode.next = new ListNode(nodeNum);
            //移动新链表指针
            newNode = newNode.next;
            //移动两个链表指针
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //最后根据进位，确定是否需要在尾部添加节点
        if (carry != 0) {
            newNode.next = new ListNode(carry);
        }
        return newHead.next;
    }
}
