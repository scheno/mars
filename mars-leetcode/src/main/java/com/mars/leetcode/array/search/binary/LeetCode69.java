package com.mars.leetcode.array.search.binary;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/9/1 15:18
 */
public class LeetCode69 {

    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int middle = (left + right) / 2;
            long mul = (long) middle * middle;
            if (mul > x) {
                right = middle - 1;
            } else if (mul < x) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        LeetCode69 leetCode69 = new LeetCode69();
        leetCode69.mySqrt(2147395599);
    }
}
