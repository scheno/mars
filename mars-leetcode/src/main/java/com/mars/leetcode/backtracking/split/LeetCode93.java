package com.mars.leetcode.backtracking.split;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/30 10:04 下午
 */
public class LeetCode93 {

    List<String> path;

    List<String> result;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        path = new ArrayList<>();
        dfs(s, 0, 4);
        return result;
    }

    public void dfs(String s, int start, int residue) {
        if (start == s.length()) {
            if (residue == 0) {
                result.add(String.join(".", path));
            }
            return;
        }
        for (int i = start; i < start + 3; i++) {
            if (i >= s.length()) {
                break;
            }
            if (residue * 3 < s.length() - i) {
                continue;
            }
            if (judgeIpSegment(s, start, i)) {
                String currentIpSegment = s.substring(start, i + 1);
                path.add(currentIpSegment);
                dfs(s, i + 1, residue - 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int length = right - left + 1;
        if (length > 1 && s.charAt(left) == '0') {
            return false;
        }
        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >=0 && res <= 255;
    }
}
