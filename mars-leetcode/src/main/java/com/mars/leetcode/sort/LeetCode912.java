package com.mars.leetcode.sort;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/25 8:33 下午
 */
public class LeetCode912 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);

    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int mark = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                mark++;
                int temp = nums[i];
                nums[i] = nums[mark];
                nums[mark] = temp;
            }
        }
        nums[left] = nums[mark];
        nums[mark] = pivot;
        return mark;
    }

}
