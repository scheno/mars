package com.mars.leetcode.tree.merge;

import com.mars.leetcode.TreeNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/21 8:44 下午
 */
public class LeetCode617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees((root1.left), root2.left);
        root1.right = mergeTrees((root1.right), root2.right);
        return root2;
    }
}
