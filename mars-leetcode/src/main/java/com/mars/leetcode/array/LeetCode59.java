package com.mars.leetcode.array;

import java.util.ArrayList;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/31 11:44 下午
 */
public class LeetCode59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int begin = 0;

        while (begin != n * n) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = ++begin;
            }
            top++;
            if (top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = ++begin;
            }
            right--;
            if (left > right) break;

            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = ++begin;
            }
            bottom--;
            if (top > bottom) break;

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = ++begin;
            }
            left++;
            if (left > right) break;
        }

        return matrix;
    }

}
