package com.mars.leetcode.array.search.binary;

public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        // 左边界
        int leftBound = leftBound(nums, target);
        // 右边界
        int rightBound = rightBound(nums, target);
        if (rightBound < leftBound) {
            return new int[]{-1, -1};
        }
        return new int[]{leftBound, rightBound};
    }

    public int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return left;
    }

    public int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        LeetCode34 leetcode34 = new LeetCode34();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = leetcode34.searchRange(nums, 8);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

}
