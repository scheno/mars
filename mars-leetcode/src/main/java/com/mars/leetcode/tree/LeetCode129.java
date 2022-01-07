package com.mars.leetcode.tree;

import com.mars.leetcode.TreeNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/7 12:58 上午
 */
public class LeetCode129 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    public static void main(String[] args) {

    }
}
