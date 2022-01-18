package com.mars.leetcode.maximum;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/18 10:08 下午
 */
public class LeetCode53 {

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int num: nums) {
            pre = Math.max(num, pre + num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
