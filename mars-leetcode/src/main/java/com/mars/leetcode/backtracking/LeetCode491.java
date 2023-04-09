package com.mars.leetcode.backtracking;

import java.util.*;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/29 10:21 下午
 */
public class LeetCode491 {

    public List<List<Integer>> result;

    public LinkedList<Integer> path;

    public List<List<Integer>> findSubsequences(int[] nums) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            result.add(null);
        }
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int start) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (path.size() > 1) {
            result.add(new LinkedList<>(path));
        }
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && path.getLast() > nums[i]) {
                continue;
            }
            if (map.containsKey(nums[i])) {
                continue;
            }
            map.put(nums[i], i);
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
}
