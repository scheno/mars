package com.mars.leetcode.sort;

public class QuickSort {

    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int nums[], int left, int right) {
        if (left >= right) {
            return;
        }
        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);
    }

    public static int partition(int nums[], int left, int right) {
        int mark = left;
        int piovt = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < piovt) {
                mark++;
                int temp = nums[i];
                nums[i] = nums[mark];
                nums[mark] = temp;
            }
        }
        nums[left] = nums[mark];
        nums[mark] = piovt;
        return mark;
    }

    public static void main(String[] args) {
        int[] nums = {7, 9, 1, 7 ,10};
        sort(nums);
        for(int num: nums) {
            System.out.println(num);
        }
    }
}
