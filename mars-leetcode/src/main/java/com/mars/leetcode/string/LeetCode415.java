package com.mars.leetcode.string;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/27 8:59 下午
 */
public class LeetCode415 {

    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        while (i >=0 || j >=0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + add;
            builder.append(sum % 10);
            add = sum / 10;
            i--;
            j--;
        }
        return builder.reverse().toString();
    }
}
