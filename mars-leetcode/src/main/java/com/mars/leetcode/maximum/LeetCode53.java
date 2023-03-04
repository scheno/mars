package com.mars.leetcode.maximum;

/**
 * 最大子数组，这个问题可以等价于，求前面数据最大值，并和当前值比较最大值
 *
 * @author shenchen
 * @version 1.0
 * @date 2022/1/18 10:08 下午
 */
public class LeetCode53 {

    public int maxSubArray(int[] nums) {
        // 定义之前数组的最大和，如果大于则保留，如果小于则丢弃
        int prev = 0, max = nums[0];
        for (int num : nums) {
            // 比较上一个最大子数组之和与最大子数组之和与当前值之和。取最大值
            // 如果前面的和比当前小，则保留当前值为历史值之和
            prev = Math.max(prev + num, num);
            // 保留最大值
            max = Math.max(max, prev);
        }
        return max;
    }

}
