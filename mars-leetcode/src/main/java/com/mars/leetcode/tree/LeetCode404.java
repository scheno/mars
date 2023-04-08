package com.mars.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

import com.mars.leetcode.TreeNode;

/**
 * LeetCode404.左叶子之和
 * 
 * @author shenchen
 * @since 2023-04-08 23:54
 */
public class LeetCode404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                result += node.left.val;
            }
            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
        }
        return result;
    }

}
