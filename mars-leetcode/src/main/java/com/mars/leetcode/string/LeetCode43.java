package com.mars.leetcode.string;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/15 2:51 下午
 */
public class LeetCode43 {

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int sum = result[i + j + 1] + x * y;
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0) continue;
            builder.append(result[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LeetCode43.multiply("123", "456");
    }

}
