package com.mars.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode383.赎金信
 * 
 * @author shenchen
 * @since 2023-04-05 00:14
 */
public class LeetCode383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

}