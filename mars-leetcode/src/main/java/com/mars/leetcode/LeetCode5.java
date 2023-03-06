package com.mars.leetcode;

/**
 * 最长回文子序列
 *
 * 回文子序列有两种情况，一种是奇数，一种是偶数
 * 需要分别对这两种情况对两边进行扩散求取最大长度回文子串
 *
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
            int len1 = expandAroundCenter(i, i, s);
            int len2 = expandAroundCenter(i, i + 1, s);
            int len = Math.max(len1, len2);
            // 计算start和end的长度
            if (len > end - start) {
                // len 长度为偶数时，需要-1，防止start不准，因为i靠近左侧
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 查找回文子串长度
     *
     * @param left
     * @param right
     * @param s
     * @return
     */
    public int expandAroundCenter(int left, int right, String s) {
        // 0 <= left < right < s.length()
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        LeetCode5 leetCode5 = new LeetCode5();
        String result = leetCode5.longestPalindrome("abba");
        System.out.println(result);
    }

}
