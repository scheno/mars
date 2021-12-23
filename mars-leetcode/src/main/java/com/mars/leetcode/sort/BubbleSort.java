package com.mars.leetcode.sort;

public class BubbleSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void sortOptimize(int nums[]) {
        // 标志位
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    flag = false;
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
            if (flag) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 9, 1, 7 ,10};
        sortOptimize(nums);
        for(int num: nums) {
            System.out.println(num);
        }
    }
    
}
