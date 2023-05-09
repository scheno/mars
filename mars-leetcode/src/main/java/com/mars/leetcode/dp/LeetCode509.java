package com.mars.leetcode.dp;

/**
 * LeetCode509. 斐波那契数
 * 
 * @author shenchen
 * @version 1.0
 * @since 2022/2/8 11:12 下午
 */
public class LeetCode509 {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }

}
