package com.mars.leetcode.array;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/31 8:56 下午
 */
public class LeetCode41 {

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int[] helper = new int[nums.length + 1];

        for (int i = 0; i < helper.length; i++) {
            helper[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                int index = nums[i];
                helper[index] = index;
            }
        }
        for (int i = 1; i < helper.length; i++) {
            if (helper[i] == 0) {
                return i;
            }
        }
        return helper.length;
    }

}
