package com.mars.leetcode.dp;

/**
 * LeetCode63.不同路径 II
 * 
 * @author shenchen
 * @version 1.0
 * @since 2022/2/8 12:04 上午
 */
public class LeetCode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 定义dp数组，既到达m，n的路径数
        int[][] martix = new int[m][n];
        // 左侧向下只有一种路径，遇到障碍时后续路不通，置为零
        for (int i = 0; i < m; i++) {
            if (martix[i][0] == 1) {
                martix[i][0] = 0;
                break;
            } else {
                martix[i][0] = 1;
            }
            
        }
        // 上侧向右只有一种路径，遇到障碍时后续路不通，置为零
        for (int i = 0; i < n; i++) {
            if (martix[0][i] == 1) {
                martix[0][i] = 0;
            } else {
                martix[0][i] = 1;
            }
            
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 状态转移方程，上侧和左侧之和
                if (obstacleGrid[i][j] == 1) {
                    martix[i][j] = 0;
                } else {
                    martix[i][j] = martix[i - 1][j] + martix[i][j - 1];
                }
                
            }
        }
        return martix[m - 1][n - 1];
    }

}
