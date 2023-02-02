package com.mars.leetcode.array.search.binary;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/9/1 15:34
 */
public class LeetCode367 {

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid > num) {
                right = mid - 1;
            } else if ((long) mid * mid < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
