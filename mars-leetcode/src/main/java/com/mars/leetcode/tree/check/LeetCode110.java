package com.mars.leetcode.tree.check;

import com.mars.leetcode.TreeNode;

/**
 * LeetCode110.平衡二叉树
 * 
 * @author shenchen
 * @since 2022/1/19 8:57 下午
 */
public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == -1 || rightDepth == -1) {
            return -1;
        }
        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : 1 + Math.max(leftDepth, rightDepth);
    }
}
