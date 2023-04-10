package com.mars.leetcode.tree.ancestor;

import com.mars.leetcode.TreeNode;

/**
 * LeetCode235.二叉搜索树的最近公共祖先
 * 
 * @author shenchen
 * @since 2022/1/10 11:37 下午
 */
public class LeetCode235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

}
