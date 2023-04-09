package com.mars.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/29 10:13 下午
 */
public class LeetCode90 {

    List<List<Integer>> result;

    LinkedList<Integer> path;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            result.add(null);
        }
        result = new ArrayList<>();
        path = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int start) {
        result.add(new LinkedList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }

}
