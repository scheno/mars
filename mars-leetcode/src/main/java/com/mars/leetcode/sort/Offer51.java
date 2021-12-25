package com.mars.leetcode.sort;

public class Offer51 {
    int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    public void mergeSort(int[] nums, int left, int right) {
        // 递归结束条件
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        // 递归当前序列左半部分
        mergeSort(nums, left, mid);
        // 递归当前序列右半部分
        mergeSort(nums, mid + 1, right);
        // 归并结果
        merge(nums, left, mid, right);
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];
        // 左边首位下标和右边首位下标
        int l = left, r = mid + 1;
        int index = 0;
        // 把较小的数先移到新数组中
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                tempArr[index++] = arr[l];
            } else {
                //增加一行，统计逆序对
                count += (mid - l + 1);
                tempArr[index++] = arr[r];
            }
        }
        // 把左边数组剩余的移入数组
        while (l <= mid) {
            tempArr[index++] = arr[l];
        }
        // 把右面数组剩余的移入数组
        while (r <= right) {
            tempArr[index++] = arr[r];
        }
        // 将新数组的值赋给原数组
        for (int i = 0; i < tempArr.length; i++) {
            arr[i+left] = tempArr[i];
        }
    }

}
