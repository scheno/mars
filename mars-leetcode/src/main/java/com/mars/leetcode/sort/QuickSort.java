package com.mars.leetcode.sort;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/21 10:33 下午
 */
public class QuickSort {

    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex -1);
        quickSort(nums, partitionIndex + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int mark = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                mark++;
                int temp = nums[mark];
                nums[mark] = nums[i];
                nums[i] = temp;
            }
        }
        nums[left] = nums[mark];
        nums[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {5,1,1,2,0,0};
        quickSort.sort(nums);
        System.out.println(nums);
    }

}
