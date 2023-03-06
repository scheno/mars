package com.mars.leetcode.array;

/**
 * 合并两个有序数组
 *
 * @author shenchen
 * @version 1.0
 * @date 2022/1/6 7:43 下午
 */
public class LeetCode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = nums1.length - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[end--] = nums1[m--];
            } else {
                nums1[end--] = nums2[n--];
            }
        }
        if (m < 0) {
            while (n >= 0) {
                nums1[end--] = nums2[n--];
            }
        }
        if (n < 0) {
            while (m >= 0) {
                nums1[end--] = nums1[m--];
            }
        }
    }

}
