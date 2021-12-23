package com.mars.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode150 {

    public static int evalRPN(String[] tokens) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isNumber(tokens[i])) {
                queue.push(Integer.valueOf(tokens[i]));
            } else {
                int num1 = queue.pop();
                int num2 = queue.pop();
                if ("+".equals(tokens[i])) {
                    queue.push(num2 + num1);
                }
                if ("-".equals(tokens[i])) {
                    queue.push(num2 - num1);
                }
                if ("*".equals(tokens[i])) {
                    queue.push(num2 * num1);
                }
                if ("/".equals(tokens[i])) {
                    queue.push(num2 / num1);
                }
            }

        }
        return Integer.valueOf(queue.pop());

    }

    public static boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }

}
