package com.mars.leetcode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/26 7:41 下午
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 处理单个值为回文中心情况
            int len1 = expandAroundCenter(s, i, i);
            // 处理两个值为回文中心情况
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LeetCode5 leetCode5 = new LeetCode5();
        String result = leetCode5.longestPalindrome("abba");
        System.out.println(result);
    }

}
