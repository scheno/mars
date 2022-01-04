package com.mars.leetcode.array;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/4 11:26 下午
 */
public class LeetCode11 {

    public int maxArea(int[] height) {
        int maxArea = computeArea(height, 0, height.length - 1);
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int low = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, low * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public int computeArea(int[] height, int left, int right) {
        return (right - left) * Math.min(height[left], height[right]);
    }

}
