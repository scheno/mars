package com.mars.leetcode.backstack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {

    public List<String> result;

    public StringBuilder path;

    public Integer pathSum;

    String[] numsMap = {"", "",  "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        pathSum = 0;
        path = new StringBuilder();
        backtrack(digits, pathSum);
        return result;
    }

    public void backtrack(String digits, int pathSum) {
        if (pathSum == digits.length()) {
            result.add(path.toString());
            return;
        }

        // 获取映射字母
        String letters = numsMap[digits.charAt(pathSum) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(digits, pathSum + 1);
            // 回溯
            path.deleteCharAt(path.length() - 1);
        }
    }


}
