package com.mars.leetcode.array;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/31 8:30 下午
 */
public class Offer3 {

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                //判断位置是否被占
                int index = nums[i];
                if (nums[index] == nums[i]) {
                    return nums[i];
                }
                //交换位置
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
        return -1;
    }
}
