package com.mars.leetcode.tree.search;

import com.mars.leetcode.TreeNode;

/**
 * LeetCode98.验证二叉搜索树
 * 中序遍历二叉搜索树，前一个节点一定小于后一个节点
 * 
 * @author shenchen
 * @since 2022/1/9 4:39 下午
 */
public class LeetCode98 {

    private TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }

}
