package com.mars.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3 {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, ans = 0;
        for (; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int result = LeetCode3.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }

}
