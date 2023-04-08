package com.mars.leetcode.tree.depth;

import com.mars.leetcode.TreeNode;

/**
 * LeetCode111.二叉树的最小深度
 * 
 * @author shenchen
 * @since 2022/1/3 9:54 下午
 */
public class LeetCode111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null && root.right != null) {
            return rightDepth + 1;
        }
        if (root.left != null && root.right == null) {
            return leftDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
