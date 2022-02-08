package com.mars.leetcode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/2/8 9:51 下午
 */
public class LeetCode70 {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
