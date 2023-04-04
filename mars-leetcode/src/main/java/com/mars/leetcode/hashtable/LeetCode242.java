package com.mars.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode242.有效的字母异位词
 * 
 * @author shenchen
 * @since 2023-04-04 23:49
 */
public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (int value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return Boolean.TRUE;
    }
    
}
