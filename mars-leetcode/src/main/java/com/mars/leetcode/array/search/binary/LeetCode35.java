package com.mars.leetcode.array.search.binary;

/**
 * @author shenchen
 */
public class LeetCode35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        LeetCode35 leetCode35 = new LeetCode35();
        int result = leetCode35.searchInsert(nums, 0);
        System.out.println(result);
    }
}
