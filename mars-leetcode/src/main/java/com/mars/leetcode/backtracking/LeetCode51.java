package com.mars.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/29 11:03 下午
 */
public class LeetCode51 {

    List<List<String>> result;

    LinkedList<String> row;

    public List<List<String>> solveNQueens(int n) {
        // 棋盘
        char[][] board = new char[n][n];
        // 初始化棋盘
        for (char[] c: board) {
            Arrays.fill(c, '.');
        }
        backtrack(board, n, 0);
        return result;
    }

    public void backtrack(char[][] board, int n, int row) {
        if (row == n) {
            result.add(arrayToList(board));
        }
        for (int col = 0; col < n; col++) {
            if (!isValid(board, n, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(board, n, row + 1);
            board[row][col] = '.';
        }
    }

    public boolean isValid(char[][] board, int n, int row, int col) {
        //行不用判断，每层只有一个
        //col列判断
        for (int k = 0; k < n; k++) {
            if (board[k][col] == 'Q') {
                return false;
            }
        }
        //检查主对角线（45度）
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //检查副对角线（135度）
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> arrayToList(char[][] board) {
        List<String> path = new ArrayList<>();
        for (char[] c: board) {
            path.add(String.valueOf(c));
        }
        return path;
    }
}
