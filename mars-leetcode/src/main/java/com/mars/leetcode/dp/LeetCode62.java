package com.mars.leetcode.dp;

/**
 * LeetCode62.不同路径
 * 
 * @author shenchen
 * @version 1.0
 * @since 2022/2/8 12:04 上午
 */
public class LeetCode62 {

    public int uniquePaths(int m, int n) {
        // 定义dp数组，既到达m，n的路径数
        int[][] martix = new int[m][n];
        // 左侧向下只有一种路径
        for (int i = 0; i < m; i++) {
            martix[i][0] = 1;
        }
        // 上侧向右只有一种路径
        for (int i = 0; i < n; i++) {
            martix[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 状态转移方程，上侧和左侧之和
                martix[i][j] = martix[i - 1][j] + martix[i][j - 1];
            }
        }
        return martix[m - 1][n - 1];
    }

}
