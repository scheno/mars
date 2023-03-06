package com.mars.leetcode;

/**
 * 岛屿的最大面积
 * 岛屿个数的变种
 */
public class LeetCode695 {

    public int maxAreaOfIsland(int[][] grid) {
        int maxAreaOfIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxAreaOfIsland = Math.max(dfs(grid, i, j, maxAreaOfIsland), maxAreaOfIsland);
                }
            }
        }
        return maxAreaOfIsland;
    }

    public int dfs(int[][] grid, int i, int j, int maxAreaOfIsland) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        maxAreaOfIsland += 1;
        maxAreaOfIsland += dfs(grid, i - 1, j, maxAreaOfIsland);
        maxAreaOfIsland += dfs(grid, i + 1, j, maxAreaOfIsland);
        maxAreaOfIsland += dfs(grid, i, j - 1, maxAreaOfIsland);
        maxAreaOfIsland += dfs(grid, i, j + 1, maxAreaOfIsland);
        return maxAreaOfIsland;
    }

}
