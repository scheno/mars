package com.mars.leetcode.dp;

/**
 * LeetCode746.使用最小花费爬楼梯
 * 
 * @author xinghuan
 * @since 2023/5/9 23:42
 */
public class LeetCode746 {
    
    public int minCostClimbingsStairs(int[] cost) {
        if (cost.length < 2 ) {
            return 0 ;
        }
        
        int[] dp = new int[cost.length];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i -2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

}
