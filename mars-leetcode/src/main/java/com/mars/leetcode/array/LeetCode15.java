package com.mars.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和，双指针法
 *
 * @author shenchen
 * @version 1.0
 * @date 2022/1/4 10:36 下午
 */
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 如果数组长度小于3，直接返回
        if (nums.length < 3) {
            return result;
        }
        // 对数组进行排序
        Arrays.sort(nums);
        // 遍历数据，因为数组长度为3，所以最后一个数字应该是倒数第三个
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果第一个数已经大于等于0，那三数之和一定大于零
            if (nums[i] > 0) {
                return result;
            }
            // 遍历i的时候，只取用第一个元素，后面存在重复则跳过，保证nums[i]只出现一次
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            // 定义j, k的初始位置
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    // 找到左侧最后一个相同的元素，保证第二个元素不重复
                    while (j < k && nums[j] == nums[j+1]) {
                        j++;
                    }
                    // 找到右侧第一个相同的元素，保证第三个元素不重复
                    while (j < k && nums[k] == nums[k-1]) {
                        k--;
                    }
                    // 左侧右移，右侧左移
                    j++;
                    k--;
                } else if (sum > 0) {
                    // 如果总和大于零，说明右边的数大，需要左移
                    k--;
                } else {
                    // 如果总和小于零，说明左边的数小，需要右移
                    j++;
                }

            }
        }
        return result;
    }
}
