package com.mars.leetcode.array;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/31 12:25 上午
 */
public class LeetCode1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int start = 0, maxGrumpy = 0, maxSatisfied = 0;

        // 计算生气时间对应最大顾客人数
        for (int i = start; i <= customers.length - minutes; i++) {
            int result = maxGrumpy(customers, grumpy, i, i + minutes);
            if (result >= maxGrumpy) {
                maxGrumpy = result;
                start = i;
            }
        }

        // 计算最大满意顾客人数
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                maxSatisfied += customers[i];
            } else {
                if (i >= start && i < start + minutes) {
                    maxSatisfied += customers[i];
                }
            }
        }
        return maxSatisfied;

    }

    public int maxGrumpy(int[] customers, int[] grumpy, int start, int end) {
        int result = 0;
        for (int i = start; i < end; i++) {
            if (grumpy[i] == 1) {
                result += customers[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1052 leetCode = new LeetCode1052();
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        int maxSatisfied = leetCode.maxSatisfied(customers, grumpy, minutes);
        System.out.println(maxSatisfied);

    }
}
