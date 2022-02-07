package com.mars.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/2/1 10:48 下午
 */
public class LeetCode22 {

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generate("", n, n);
        return result;
    }

    public void generate(String s, int left, int right) {
        // 左右括弧都已用完
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        // 左右括号相等时只能使用左括号
        if (left == right) {
            generate(s + "(", left - 1, right);
        } else {
            // 使用左括号
            if (left > 0) {
                generate(s + "(", left - 1, right);
            }
            // 使用右括号
            generate(s + ")", left, right - 1);
        }
    }

}
