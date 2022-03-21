package com.mars.leetcode.dp;

import java.util.Arrays;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/3/9 7:58 下午
 */
public class LeetCode279 {

    public static int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int dp[] = new int[n + 1];
        for (int i = 1; i < dp.length && i<= n; i++) {
            dp[i] = max;
        }
        for (int i = 1; i <= 100 && i <= n; i++) {
            for (int j = i * i; j <= n ;j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode279.numSquares(13);
    }

}
