package com.mars.leetcode.tree;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/19 11:45 上午
 */
public class LeetCode209 {

    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;

        while (end < nums.length) {
            sum += nums[end++];
            while (sum >= target && start < end) {
                result = Math.min(result, end - start);
                sum -= nums[start++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {

    }
}
