package com.mars.leetcode.tree.reverse;

import com.mars.leetcode.TreeNode;

/**
 * LeetCode226.翻转二叉树
 * 
 * @author shenchen
 * @since 2022/1/19 7:50 下午
 */
public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
