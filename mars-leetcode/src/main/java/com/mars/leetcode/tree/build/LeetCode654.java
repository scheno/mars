package com.mars.leetcode.tree.build;

import com.mars.leetcode.TreeNode;

/**
 * @author shenchen
 * @date 2022/1/8 10:50 下午
 * @version 1.0
 */
public class LeetCode654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // 记录最大值和最大值索引
        int maxNum = -1;
        int maxIndex = 0;
        // 查找最大值
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        // 构建根节点
        TreeNode root = new TreeNode(maxNum);
        // 处理左孩子
        root.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        // 处理右孩子
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        return root;
    }
}
