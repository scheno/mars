package com.mars.leetcode.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * 该题除了暴力解法之外，可以利用Map缓存已经被遍历过的数值及对应下标，
 * 当target-nums[i]的值在map中存在，则就找到了对应下标位置
 *
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
