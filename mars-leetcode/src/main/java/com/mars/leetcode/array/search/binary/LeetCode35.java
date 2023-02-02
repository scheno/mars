package com.mars.leetcode.array.search.binary;

public class LeetCode35 {

    public int searchInsert(int[] nums, int target) {
        int mid = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return mid + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        LeetCode35 leetCode35 = new LeetCode35();
        int result = leetCode35.searchInsert(nums, 0);
        System.out.println(result);
    }
}
