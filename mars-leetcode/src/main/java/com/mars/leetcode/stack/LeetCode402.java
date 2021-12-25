package com.mars.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode402 {

    public String removeKdigits(String num, int k) {
        int count = 0;
        if (num.length() == k) {
            return "0";
        }
        // 栈
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i< num.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && count < k) {
                stack.pop();
                count++;
            }
            // 栈为空，且当前位为0时，不需要入栈
            if (stack.isEmpty() && num.charAt(i) == '0') continue;
            stack.push(num.charAt(i));
        }
        while (!stack.isEmpty() && count < k) {
            stack.pop();
            count++;
        }
        //这个是最后栈为空时，删除一位，比如我们的10，删除一位为0，
        //按上面逻辑我们会返回""，所以我们让其返回"0"
        if (stack.isEmpty()) return "0";
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode402 leetCode402 = new LeetCode402();
        String num = "10200";
        String result = leetCode402.removeKdigits(num, 1);
        System.out.println(result);
    }

}
