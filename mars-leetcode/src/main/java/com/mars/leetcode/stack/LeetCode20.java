package com.mars.leetcode.stack;

import java.util.Stack;

/**
 *
 * 有效的括号
 * 当遇到左侧括号时，放入栈中
 * 当遇到右侧括号时，与弹出的栈顶元素比较，不匹配则返回false
 * 最后看栈内是否为空
 *
 *
 * @author shenchen
 * @version 1.0
 * @date 2022/1/25 9:03 下午
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }

}
