package com.mars.leetcode.dp;

import java.util.*;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/3/9 10:39 下午
 */
public class LeetCode139 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (wordSet.contains(str) && dp[j] == true) {
                    dp[i] = true;
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(LeetCode139.wordBreak("leetcode", wordDict));
    }
}
