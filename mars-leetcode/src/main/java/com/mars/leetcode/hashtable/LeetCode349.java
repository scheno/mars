package com.mars.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/4 8:53 下午
 */
public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums1) {
            numSet.add(num);
        }
        for (int num: nums2) {
            if (numSet.contains(num)) {
                result.add(num);
            }
        }
        int[] resultSet = new int[result.size()];
        int i = 0;
        for (int num: result) {
            resultSet[i++] = num;
        }
        return resultSet;
    }
}
