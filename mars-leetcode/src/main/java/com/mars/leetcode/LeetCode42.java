package com.mars.leetcode;

import com.mars.leetcode.linkedlist.LeetCode25;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/13 11:50 下午
 */
public class LeetCode42 {

    public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int result = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                leftMax[i] = height[i];
            } else {
                leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            }

        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                rightMax[i] = height[i];
            } else {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
        }
        for (int i = 0; i < height.length; i++) {
            int low = Math.min(leftMax[i], rightMax[i]);
            if (height[i] < low) {
                result += low - height[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[] {4, 2, 0, 3, 2, 5};
        LeetCode42.trap(height);
    }
}
