package com.mars.leetcode.array.remove;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/26 9:24 下午
 */
public class LeetCode977 {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        for (int i = right; i >= 0; i--) {
            int leftMul = nums[left] * nums[left];
            int rightMul = nums[right] * nums[right];
            if (leftMul > rightMul) {
                left++;
                result[i] = leftMul;
            } else {
                right--;
                result[i] = rightMul;
            }
        }
        return result;
    }
}
