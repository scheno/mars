package com.mars.leetcode.tree;

import com.mars.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/17 10:21 下午
 */
public class LeetCode114 {

    public void flatten(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        prevTraversal(root, queue);
        TreeNode prev = null;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            node.left = null;
            node.right = prev;
            prev = node;
        }
    }

    public void prevTraversal(TreeNode root, Deque<TreeNode> queue) {
        if (root != null) {
            queue.push(root);
            prevTraversal(root.left, queue);
            prevTraversal(root.right, queue);
        }
    }

}
