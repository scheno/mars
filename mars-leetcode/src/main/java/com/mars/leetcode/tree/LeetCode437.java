package com.mars.leetcode.tree;

import com.mars.leetcode.TreeNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/8 3:11 下午
 */
public class LeetCode437 {

    int result = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return result;
        }
        // 根几点
        traversal(root, targetSum);
        // 左孩子节点
        pathSum(root.left, targetSum);
        // 右孩子节点
        pathSum(root.right, targetSum);
        return result;
    }

    public void traversal(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        // 路径和
        sum -= root.val;
        if (sum == 0) {
            result++;
        }
        // 递归左子树
        traversal(root.left, sum);
        // 递归右子树
        traversal(root.right, sum);
    }

}
