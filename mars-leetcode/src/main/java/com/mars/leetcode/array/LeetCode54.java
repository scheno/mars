package com.mars.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * 遍历上侧和右侧，全部遍历
 * 因为存在同一行的现象，所以对下侧和左侧遍历，需要进行判断是否在两行
 *
 * @author shenchen
 * @version 1.0
 * @date 2021/12/31 11:31 下午
 */
public class LeetCode54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, left = 0;
        int buttom = matrix.length - 1, right = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();

        while (top <= buttom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top+1; i <= buttom; i++) {
                result.add(matrix[i][right]);
            }
            if (left < right && top < buttom) {
                for (int i = right - 1; i > left; i--) {
                    result.add(matrix[buttom][i]);
                }
                for (int i = buttom; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            top++;
            left++;
            buttom--;
            right--;
        }
        return result;
    }

}
