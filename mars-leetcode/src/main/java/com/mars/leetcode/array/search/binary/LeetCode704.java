package com.mars.leetcode.array.search.binary;

/**
 * @author shenchen
 */
public class LeetCode704 {

    public int search(int[] nums, int target) {
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
        return -1;
    }

    public static void main(String[] args) {
        LeetCode704 leetCode704 = new LeetCode704();
        int[] nums = new int[] {1, 2, 3, 4, 5, 6};
        int result = leetCode704.search(nums, 5);
        System.out.println(result);
    }
}
