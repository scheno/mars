package com.mars.leetcode.array.search;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/2/7 9:02 下午
 */
public class LeetCode33 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 中值比较
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 判断当前区间是否为旋转数组
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
