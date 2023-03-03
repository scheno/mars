package com.mars.leetcode.array;

/**
 * 数组中的第K个最大元素，利用快速排序，再利用分片进一步优化
 *
 * @author shenchen
 * @version 1.0
 * @date 2022/1/6 11:50 下午
 */
public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSort(int[] nums, int start, int end, int index) {
        // 获取第一个数组第一个元素排序后所在位置
        int partitionIndex = partitionIndex(nums, start, end);
        // 如果该值等于第k个元素所在位置，说明该位置的值就是第K个大的值，直接返回
        if (partitionIndex == index) {
            return nums[index];
        }
        // 如果partitionIndex小于index，那么说明index则在数组的右侧，否则在左侧，继续进行查找
        return partitionIndex < index ? quickSort(nums, partitionIndex + 1, end, index) : quickSort(nums, start, partitionIndex - 1, index);
    }

    /**
     * 获取数组第一个值数据中所在位置，此时左边元素比初始数组第一个小，右边元素比初始数组第一个大
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int partitionIndex(int[] nums, int start, int end) {
        int mark = start;
        for (int i = mark + 1; i <= end; i++) {
            if (nums[i] < nums[start]) {
                swap(nums, i, ++mark);
            }
        }
        swap(nums, start, mark);
        return mark;
    }

    /**
     * 交换函数
     *
     * @param nums
     * @param m
     * @param n
     */
    public void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }


    public static void main(String[] args) {
        LeetCode215 leetCode215 = new LeetCode215();
        int[] array = new int[] {5, 7, 8, 1, 3, 6};
        int result = leetCode215.findKthLargest(array, 1);
        System.out.println(result);
    }

}
