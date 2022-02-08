package com.mars.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/2/8 7:42 下午
 */
public class LeetCode128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }
        // 定义最长连续序列
        int longestLength = 0;
        // 遍历所有元素
        for (int num: nums) {
            if (!numSet.contains(num - 1)) {
                // 定义当前连续数组长度
                int currentLength = 1;
                while (numSet.contains(num + 1)) {
                    num += 1;
                    currentLength += 1;
                }
                // 判断最长连续序列
                longestLength = Math.max(longestLength, currentLength);
            }
        }
        return longestLength;
    }

}
