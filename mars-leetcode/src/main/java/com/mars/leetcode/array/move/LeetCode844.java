package com.mars.leetcode.array.move;

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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != '#') {
                stringBuilder.append(ch);
            } else {
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }
        return stringBuilder.toString();
    }
}
