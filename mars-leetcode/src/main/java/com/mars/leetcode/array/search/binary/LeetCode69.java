package com.mars.leetcode.array.search.binary;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/9/1 15:18
 */
public class LeetCode69 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid < x) {
                left = mid + 1;
            } else if ((long) mid * mid > x) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left - 1;
    }
}
