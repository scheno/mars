package com.mars.leetcode.tree.search;

import com.mars.leetcode.TreeNode;

/**
 * LeetCode700.二叉搜索树中的搜索
 * 
 * @author shenchen
 * @since 2022/1/9 4:21 下午
 */
public class LeetCode700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

}
