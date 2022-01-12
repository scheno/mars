package com.mars.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode216 {

    public List<List<Integer>> result;

    public LinkedList<Integer> path;

    int pathSum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        backtrack(k, n, 1);
        return result;
    }

    public void backtrack(int k, int n, int start) {
        //剪枝优化
        if (pathSum > n) {
            return;
        }

        //结束
        if (path.size() == k) {
            if (pathSum == n) {
                result.add(new LinkedList<>(path));
            }
            return;
        }
        //遍历序列
        for (int i = start; i <= 9; i++) {
            path.push(i);
            pathSum += i;
            //递归
            backtrack(n, k, i + 1);
            //回溯，撤销操作
            pathSum -= path.pop();
        }
    }
}
