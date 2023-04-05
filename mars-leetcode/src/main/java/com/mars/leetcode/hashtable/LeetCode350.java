package com.mars.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode.350 两个数组的交集 II
 * 
 * @author shenchen
 * @since 2023-04-05 14:59
 */
public class LeetCode350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums1) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (numMap.containsKey(num)) {
                result.add(num);
                int count = numMap.get(num);
                count -= 1;
                if (count <= 0) {
                    numMap.remove(num);
                } else {
                    numMap.put(num, count);
                }
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }

}
