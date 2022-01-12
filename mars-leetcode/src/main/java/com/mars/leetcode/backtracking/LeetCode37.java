package com.mars.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode37 {

    public List<List<Integer>> result;

    public LinkedList<Integer> path;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>(16);
        path = new LinkedList<>();
        backtrack(n, k, 1);
        return result;
    }

    public void backtrack(int n, int k, int start) {
        if (path.size() == k) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrack(n ,k, i + 1);
            path.removeLast();
        }
    }
}
