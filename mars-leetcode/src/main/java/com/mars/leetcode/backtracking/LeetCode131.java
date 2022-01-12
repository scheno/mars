package com.mars.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/29 8:29 下午
 */
public class LeetCode131 {

    List<List<String>> result;

    LinkedList<String> path;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        backtrack(s, 0);
        return result;
    }

    public void backtrack(String s, int start) {
        if (start >= s.length()) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalidrome(s, start, i)) {
                String r = s.substring(start, i + 1);
                path.addLast(r);
            }
            backtrack(s, i + 1);
            path.removeLast();
        }
    }

    public boolean isPalidrome(String s, int start, int end) {
        for (int i = start, j = end; start < end; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
