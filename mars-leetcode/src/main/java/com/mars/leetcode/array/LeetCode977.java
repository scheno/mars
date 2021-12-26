package com.mars.leetcode.array;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/26 9:24 下午
 */
public class LeetCode977 {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int r = nums.length - 1;
        while (left <= right) {
            int leftRes = nums[left] * nums[left];
            int rightRes = nums[right] * nums[right];
            if (leftRes <= rightRes) {
                result[r] = rightRes;
                right--;
            } else {
                result[r] = leftRes;
                left++;
            }
            r--;
        }
        return result;
    }
}
