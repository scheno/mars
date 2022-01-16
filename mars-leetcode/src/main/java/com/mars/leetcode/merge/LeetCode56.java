package com.mars.leetcode.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/16 9:30 下午
 */
public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] intervals1, int[] intervals2) {
                return intervals1[0] - intervals2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
    }
}
