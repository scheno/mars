package com.mars.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode202.快乐数
 * 
 * @author shenchen
 * @since 2023-04-05 15:46
 */
public class LeetCode202 {

    public boolean isHappy(int n) {
        Set<Integer> result = new HashSet<>();
        while (n != 1 && !result.contains(n)) {
            result.add(n);
            n = getNextNumber(n);
        }
        return 1 == n;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res = res + temp * temp;
            n = n / 10;
        }
        return res;
    }
    
}
