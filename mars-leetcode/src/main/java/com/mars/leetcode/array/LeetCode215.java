package com.mars.leetcode.array;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/6 11:50 下午
 */
public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {
        quickSork(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public int partition(int[] nums, int start, int end) {
        int mark = start;
        int pivot = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < pivot) {
                mark++;
                int temp = nums[i];
                nums[i] = nums[mark];
                nums[mark] = temp;
            }
        }
        nums[start] = nums[mark];
        nums[mark] = pivot;
        return mark;
    }

    public void quickSork(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int partitionIndex = partition(nums, start, end);
        quickSork(nums, start, partitionIndex - 1);
        quickSork(nums, partitionIndex + 1, end);
    }

    public static void main(String[] args) {
        LeetCode215 leetCode215 = new LeetCode215();
        int[] array = new int[] {5, 7, 8, 1, 3, 6};
        leetCode215.findKthLargest(array, 1);
    }

}
