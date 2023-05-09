package com.mars.leetcode.dp;

/**
 * LeetCode70. 爬楼梯
 *
 * @author shenchen
 * @version 1.0
 * @date 2022/2/8 9:51 下午
 */
public class LeetCode70 {

    public int climbStairs(int n) {
        // 当台阶数小于等于2时，只有n种方法
        if (n <= 2) {
            return n;
        }
        // 定义动态规划数组
        int[] dp = new int[n + 1];
        // 定义初始化前两个方法
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
