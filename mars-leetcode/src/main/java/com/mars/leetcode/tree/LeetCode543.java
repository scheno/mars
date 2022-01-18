package com.mars.leetcode.tree;

import com.mars.leetcode.TreeNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/18 11:41 下午
 */
public class LeetCode543 {

    Integer diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        backtracking(root);
        return diameter;
    }

    public int backtracking(TreeNode root) {
        if (root == null) return 0;
        int left = backtracking(root.left);
        int right = backtracking(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

}
