package com.mars.leetcode.string;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/6 7:48 下午
 */
public class LeetCode165 {

    public int compareVersion(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String a = "1.01";
        String b = "1.001";
        LeetCode165 leetCode165 = new LeetCode165();
        int result = leetCode165.compareVersion(a, b);
        System.out.println(result);
    }
}
