package com.mars.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * 解题思路：
 *    先对数组进行排序
 *    再对区间进行合并
 * 特殊问题：
 *    需要处理后一个区间全部在上一个区间的情况
 *
 * @author shenchen
 * @version 1.0
 * @date 2023/4/2 21:17
 */
public class LeetCode56 {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] intervals1, int[] intervals2) {
                return intervals1[0] - intervals2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];
            if (merged.isEmpty() || left > merged.get(merged.size())[1]) {
                merged.add(new int[]{left, right});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(right,  merged.get(merged.size() - 1)[1]);
            }
        }
        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = new int[] {merged.get(i)[0], merged.get(i)[1]};
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(array);
    }

}
