package com.mars.leetcode.tree;

import com.mars.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/1 9:52 下午
 */
public class Offer32 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelCount = 1;

        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int levelSize = queue.size();
            for (int i = 1; i <= levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (levelCount % 2 != 0) {
                    level.addLast(node.val);
                }
                if (levelCount % 2 == 0) {
                    level.addFirst(node.val);
                }
            }
            levelCount++;
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        Offer32 offer32 = new Offer32();
        offer32.levelOrder(node3);
    }
}
