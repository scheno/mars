package com.mars.leetcode.sort;

public class LeetCode704 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode704 leetCode704 = new LeetCode704();
        int[] nums = new int[] {1, 2, 3, 4, 5, 6};
        int result = leetCode704.search(nums, 5);
        System.out.println(result);
    }
}
