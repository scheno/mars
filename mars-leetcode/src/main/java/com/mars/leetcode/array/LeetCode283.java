package com.mars.leetcode.array;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/26 9:00 下午
 */
public class LeetCode283 {

    public void moveZeroes(int[] nums) {
        int front = 0;
        int after = 0;
        for (; front < nums.length; front++) {
            if (nums[front] != 0) {
                nums[after] = nums[front];
                nums[front] = 0;
                after++;
            }
        }
    }

}
