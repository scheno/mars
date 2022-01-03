package com.mars.leetcode.tree;

import com.mars.leetcode.TreeNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/3 9:25 下午
 */
public class LeetCode104 {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int leftDepth = depth + 1;
        int rightDepth = depth + 1;
        if (root.left != null) {
            leftDepth = maxDepth(root.left, leftDepth);
        }
        if (root.right != null) {
            rightDepth = maxDepth(root.right, rightDepth);
        }
        return Math.max(leftDepth, rightDepth);
    }

}
