package com.mars.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode1047 {

    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c != stack.peek()) {
                // 入栈
                stack.push(c);
            } else {
                // 栈顶元素出栈
                stack.pop();
            }
        }
        // 拼接栈中字符
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

}
