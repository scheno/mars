package com.mars.leetcode.tree.check;

import com.mars.leetcode.TreeNode;

/**
 * LeetCode101. 对称二叉树
 * 
 * @author shenchen
 * @since 2022/1/3 8:56 下午
 */
public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        // 调用递归函数，比较左孩子和右孩子
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        // 1、左右两个节点都为空
        if (left == null && right == null) {
            return true;
        }
        // 2、左右两个节点有一个为空
        if (left == null || right == null) {
            return false;
        }
        // 3、左右两个节点都不为空
        if (left.val != right.val) {
            return false;
        }

        // 递归左节点的左孩子和右节点的右孩子
        boolean outSide = isSymmetric(left.left, right.right);
        // 递归左节点的右孩子和右节点的左孩子
        boolean inSide = isSymmetric(left.right, right.left);

        return outSide && inSide;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        LeetCode101 leetCode101 = new LeetCode101();
        leetCode101.isSymmetric(node1);
    }

}
