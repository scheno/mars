package com.mars.leetcode.stack;

import java.util.Stack;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/6 10:32 下午
 */
public class Offer31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        Offer31 offer31 = new Offer31();
        offer31.validateStackSequences(pushed, popped);
    }
}
