package com.mars.leetcode.array.search.binary;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/9/1 15:34
 */
public class LeetCode367 {

    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int middle = (left + right) / 2;
            long mul = (long) middle * middle;
            if (mul > num) {
                right = middle - 1;
            } else if (mul < num) {
                left = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
