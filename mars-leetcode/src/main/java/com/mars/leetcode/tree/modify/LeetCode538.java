package com.mars.leetcode.tree.modify;

import com.mars.leetcode.TreeNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/11 6:49 下午
 */
public class LeetCode538 {

    private int pre = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root.right);
        dfs(root.left);
        root.val = root.val + pre;
        pre = root.val;
        return root;
    }
}
