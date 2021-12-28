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

}
