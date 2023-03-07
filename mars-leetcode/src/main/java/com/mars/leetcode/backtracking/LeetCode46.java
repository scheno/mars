package com.mars.leetcode.backtracking;

import java.util.ArrayList;

import java.util.List;

/**
 * 全排列
 * 经典回溯算法
 * 由于是全排列，则每次遍历不需要指定起始位置
 * 由于数据不能存在重复，需要定义used数组对已使用数据做标记
 *
 * @author shenchen
 * @version 1.0
 * @date 2021/12/29 10:40 下午
 */
public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] used = new int[nums.length];
        backtracking(nums, used, path, result);
        return result;
    }

    public void backtracking(int[] nums, int[] used, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backtracking(nums, used, path, result);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }

}
