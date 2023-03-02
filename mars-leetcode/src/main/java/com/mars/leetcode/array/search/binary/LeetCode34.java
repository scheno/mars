package com.mars.leetcode.array.search.binary;

public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        int leftBorder = leftBorder(nums, target), rightBorder = rightBorder(nums, target);
        if (leftBorder > rightBorder) {
            return new int[] {-1 ,-1};
        }
        return new int[] {leftBorder, rightBorder};
    }

    public int leftBorder(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    public int rightBorder(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
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
