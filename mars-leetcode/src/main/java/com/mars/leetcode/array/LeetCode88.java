package com.mars.leetcode.array;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/6 7:43 下午
 */
public class LeetCode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1, second = n - 1;
        int tail = m + n - 1;
        int cur;
        while (first >= 0 || second >= 0) {
            if (first == -1) {
                cur = nums2[second--];
            } else if (second == -1) {
                cur = nums1[first--];
            } else if (nums1[first] >= nums2[second]) {
                cur = nums1[first--];
            } else {
                cur = nums2[second--];
            }
            nums1[tail--] = cur;
        }
    }

}
