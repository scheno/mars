package com.mars.leetcode;

/**
 * 岛屿数量
 * 采用深度优先遍历，对第一个1进行计数，然后利用深度优先遍历将所有1置为0
 */
public class LeetCode200 {

    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        LeetCode200 leetCode200 = new LeetCode200();
        char[][] grid = new char[][] {
                {'1','0','1','1','0','1','1'}
        };
        int numsIslands = leetCode200.numIslands(grid);
        System.out.println(numsIslands);
    }
}
