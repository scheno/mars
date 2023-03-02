package com.mars.leetcode.array.remove;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/26 8:38 下午
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        int front = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[front] = nums[i];
                front++;
            }
        }
        return front;
    }

}
