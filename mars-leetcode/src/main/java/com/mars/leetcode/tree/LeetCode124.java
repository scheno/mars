package com.mars.leetcode.tree;

import com.mars.leetcode.TreeNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/27 4:44 下午
 */
public class LeetCode124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    public int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int pathSum = root.val;
        int leftSum = Math.max(maxPath(root.left), 0);
        int rightSum = Math.max(maxPath(root.right), 0);

        int tempMax = pathSum + leftSum + rightSum;
        max = Math.max(max, tempMax);
        return pathSum + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        LeetCode124 leetCode124 = new LeetCode124();
        int result = leetCode124.maxPathSum(node1);
        System.out.println(result);
    }

}
