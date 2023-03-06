package com.mars.leetcode.array.search;

/**
 * 搜索旋转排序数组
 * 本题还是采用二分法进行处理
 * 由于数组存在逆序情况，那二分之后左右两边数据有一侧是顺序存在的
 * 那只需要判断目标数值是否在该顺序区间内，如果在，则讲数组限定在该区间，否则放在另外一边
 *
 * @author shenchen
 * @version 1.0
 * @date 2022/2/7 9:02 下午
 */
public class LeetCode33 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左侧数组有序
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            // 右侧数组有序
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
