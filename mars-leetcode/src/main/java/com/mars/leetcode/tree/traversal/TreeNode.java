package com.mars.leetcode.tree.traversal;

/**
 * @author shenchen
 * @version 1.0
 * @date 2023/3/5 21:20
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
