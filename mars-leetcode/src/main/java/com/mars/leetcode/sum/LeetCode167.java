package com.mars.leetcode.sum;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/17 3:30 下午
 */
public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            int start = i + 1, end = numbers.length - 1;
            while (start <= end) {
                int y = target - x;
                int mid = (start + end) / 2;
                if (y == numbers[mid]) return new int[] {i + 1, mid + 1};
                if (numbers[mid] > y) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return new int[] {-1 ,-1};
    }

}
