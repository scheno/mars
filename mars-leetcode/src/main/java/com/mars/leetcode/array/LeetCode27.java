package com.mars.leetcode.array;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/26 8:38 下午
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        int front = 0;
        int after = 0;
        for (;front < nums.length; front++) {
            if (nums[front] != val) {
                nums[after] = nums[front];
                after++;
            }
        }
        return after;
    }

    public static void main(String[] args) {

    }
}
