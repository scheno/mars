package com.mars.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/30 11:25 下午
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        int start = 0, end = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 避免指针回退
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, i);
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode3 leetCode = new LeetCode3();
        int length = leetCode.lengthOfLongestSubstring("abba");
        System.out.println(length);
    }
}
