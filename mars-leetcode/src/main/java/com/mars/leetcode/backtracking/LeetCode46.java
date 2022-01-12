package com.mars.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/29 10:40 下午
 */
public class LeetCode46 {

    List<List<Integer>> result;

    LinkedList<Integer> path;

    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            result.add(null);
        }
        backtrack(nums);
        return result;
    }

    public void backtrack(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            backtrack(nums);
            path.removeLast();
            used[i] = false;
        }
    }

}
