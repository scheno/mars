package com.mars.leetcode.tree;

import com.mars.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/13 12:23 上午
 */
public class LeetCode958 {

    Deque<TreeNode> queue;

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while ((node = queue.poll()) != null) {
            queue.offer(node.left);
            queue.offer(node.right);
        }
        for (TreeNode temp: queue) {
            if (temp != null) {
                return false;
            }
        }
        return true;
    }
}
