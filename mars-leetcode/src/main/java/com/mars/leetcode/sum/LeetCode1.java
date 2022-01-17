package com.mars.leetcode.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/17 3:33 下午
 */
public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) return new int[] {map.get(x), i};
            map.put(nums[i], i);
        }
        return new int[] {-1 ,-1};
    }

}
