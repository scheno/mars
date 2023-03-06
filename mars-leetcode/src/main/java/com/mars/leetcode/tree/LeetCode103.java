package com.mars.leetcode.tree;

import com.mars.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历
 *
 * @author shenchen
 * @version 1.0
 * @date 2022/1/12 10:45 下午
 */
public class LeetCode103 {

    List<List<Integer>> result = new ArrayList();
    Deque<TreeNode> queue = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return result;
        queue.offer(root);
        // 数层数
        int levelIndex = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> level = new LinkedList();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (levelIndex % 2 == 0) {
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(new ArrayList(level));
            levelIndex++;
        }
        return result;
    }

}
