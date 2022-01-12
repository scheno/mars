package com.mars.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/29 10:02 下午
 */
public class LeetCode78 {

    List<List<Integer>> result;

    LinkedList<Integer> path;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int start) {
        result.add(new LinkedList<>(path));
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
}
