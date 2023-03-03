package com.mars.leetcode.array.remove;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/26 8:49 下午
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int front = 0, after = 0;
        for (; front < nums.length; front++) {
            if (nums[after] != nums[front]) {
                after++;
                nums[after] = nums[front];
            }
        }
        return after + 1;
    }

}
