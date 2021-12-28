package com.mars.leetcode.backstack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode40 {

    public List<List<Integer>> result;

    public LinkedList<Integer> path;

    int pathSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();
        path = new LinkedList<>();
        backtrack(candidates, target, 0);
        return result;
    }

    public void backtrack(int[] candidates, int target, int start) {
        //剪枝优化
        if (pathSum > target) {
            return;
        }

        //结束
        if (pathSum == target) {
            result.add(new LinkedList<>(path));
            return;
        }

        //遍历序列
        for (int i = 0; i < candidates.length; i++) {
            if (i > start && candidates[i] ==candidates[i - 1]) {
                continue;
            }
            path.push(candidates[i]);
            pathSum += candidates[i];
            //递归
            backtrack(candidates, target, i + 1);
            //回溯，撤销操作
            pathSum -= path.pop();
        }
    }
}
