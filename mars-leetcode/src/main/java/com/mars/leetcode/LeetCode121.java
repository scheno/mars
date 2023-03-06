package com.mars.leetcode;

/**
 * 买卖股票的最佳时机
 * 该问题可以转换为求数组最小值问题。
 * 由于股票只能先买后卖，在求得最小值之后只需要依次比较后续数组值与当前值的差值。
 * 当遇到比该最小值小的数，替换该最小值，并继续参与计算。
 */
public class LeetCode121 {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        LeetCode121 leetCode121 = new LeetCode121();
        int[] array = new int[] {7,1,5,3,6,4};
        leetCode121.maxProfit(array);
    }

}
