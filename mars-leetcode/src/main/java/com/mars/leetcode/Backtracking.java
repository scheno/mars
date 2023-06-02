package com.mars.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    List<List<Integer>> result = new ArrayList<>();

    List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> calculate(int m, int n) {
        int start = 0;
        backtracking(m, n, start);
        return result;
    }

    public void backtracking(int m, int n, int start) {
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < m; i++) {
            path.add(Integer.valueOf(i + 1));
            backtracking(m, n, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Backtracking backtracking = new Backtracking();
        List<List<Integer>> result = backtracking.calculate(20, 3);
        for (List<Integer> path : result) {
            System.out.println(path);
        }
        System.out.println(result.size());

    }
    
}
