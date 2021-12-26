package com.mars.leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/22 6:59 下午
 */
public class LeetCode347 {
    public static int[] topKFrequent(int[] nums, int k) {
//使用HashMap存储元素出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //桶
        List<Integer>[] buckets = new List[nums.length];
        //往桶里添加元素出现次数
        for (Integer key : map.keySet()) {
            //根据出现频率决定元素入哪个桶
            int count = map.get(key);
            //初始化桶
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            //将元素存到桶中
            buckets[count].add(key);
        }
        //结果列表
        List<Integer> result = new ArrayList<>();
        //取倒数k个非空桶中的元素
        for (int i = buckets.length - 1; k > 0; i--) {
            if (buckets[i] != null) {
                //取出桶中的元素
                for (Integer num : buckets[i]) {
                    result.add(num);
                    k--;
                }
            }
        }
        //将列表中的元素赋给数组
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int[] result = topKFrequent(nums, 2);
        System.out.println(result);
    }
}
