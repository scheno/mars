package com.mars.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/20 1:49 下午
 */
class MyQueue {

    Deque<Integer> headStack, tailStack;

    public MyQueue() {
        this.headStack = new LinkedList<>();
        this.tailStack = new LinkedList<>();
    }

    public void push(int x) {
        tailStack.push(x);
    }

    public int pop() {
        if (!empty()) {
            headStack.pop();
        }
        return -1;
    }

    public int peek() {
        if (!empty()) {
            headStack.peek();
        }
        return -1;
    }

    public boolean empty() {
        if (headStack.isEmpty()) {
            while (!tailStack.isEmpty()) {
                headStack.push(tailStack.pop());
            }
        }
        return headStack.isEmpty();
    }
}

public class LeetCode232 {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue);
        System.out.println("peek " + myQueue.peek());
        System.out.println("pop: " + myQueue.pop());
        System.out.println("empty:" + myQueue.empty());
    }

}
