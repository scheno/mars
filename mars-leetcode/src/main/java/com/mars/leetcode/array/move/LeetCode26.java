package com.mars.leetcode.array.move;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/26 8:49 下午
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int front = 1;
        int after = 1;
        for (; front < nums.length; front++) {
            if (nums[front] != nums[front - 1]) {
                nums[after++] = nums[front];
            }
        }
        return after;
    }

}
