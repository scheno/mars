package com.mars.leetcode.array.remove;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/9/1 17:08
 */
public class LeetCode844 {

    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public String build(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '#') {
                builder.append(c);
            } else {
                if (builder.length() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
        }
        return builder.toString();
    }
}
