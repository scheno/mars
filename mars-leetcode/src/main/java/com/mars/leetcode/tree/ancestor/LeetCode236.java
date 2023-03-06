package com.mars.leetcode.tree.ancestor;

import com.mars.leetcode.TreeNode;

/**
 * 二叉树的最近公共祖先
 * DFS, 一直深度遍历，当有两个返回值时，说明节点在左右两侧，返回该节点。
 * 当只有一个返回值时，说明在节点一侧，返回的节点既为父节点
 *
 * @author shenchen
 * @version 1.0
 * @date 2022/1/10 9:07 下午
 */
public class LeetCode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right != null) {
            return right;
        }
        if (left != null && right == null) {
            return left;
        }
        return null;
    }

}
