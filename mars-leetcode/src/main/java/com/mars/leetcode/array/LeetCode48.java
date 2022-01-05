package com.mars.leetcode.array;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/5 3:43 下午
 */
public class LeetCode48 {

    public void rotate(int[][] matrix) {
        int left = 0, right = matrix.length - 1;
        int top = 0, bottom = matrix.length - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                // 处理上侧
                int temp = matrix[i][right];
                matrix[i][right] = matrix[top][i];
                // 处理右侧
                temp = temp + matrix[bottom][right - i + left];
                matrix[bottom][right - i + left] = temp - matrix[bottom][right - i + left];
                temp = temp - matrix[bottom][right - i + left];
                // 处理下侧
                temp = temp + matrix[bottom - i + left][left];
                matrix[bottom - i + left][left] = temp - matrix[bottom - i + left][left];
                temp = temp - matrix[bottom - i + left][left];
                // 处理左侧
                matrix[top][i] = temp;
            }
            top++;
            left++;
            right--;
            bottom--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        LeetCode48 leetCode48 = new LeetCode48();
        leetCode48.rotate(matrix);
        System.out.println(matrix);
    }
}

// 1 2
// 1 2
