package com.mars.leetcode.tree.modify;

import com.mars.leetcode.TreeNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/11 12:00 上午
 */
public class LeetCode701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
