package com.mars.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/4 10:36 下午
 */
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        // 排序
        Arrays.sort(nums);
        for (int a = 0 ; a <  nums.length - 2; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int b = a + 1, c = nums.length - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[a], nums[b], nums[c])));
                    while (b < c && nums[b] == nums[b + 1]) {
                        b++;
                    }
                    while (b < c && nums[c] == nums[c - 1]) {
                        c--;
                    }
                    b++;
                    c--;
                } else if (sum < 0) {
                    b++;
                } else if (sum > 0) {
                    c--;
                }
            }
        }
        return result;
    }
}
