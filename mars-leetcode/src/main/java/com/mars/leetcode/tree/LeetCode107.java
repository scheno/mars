package com.mars.leetcode.tree;

import com.mars.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/1 10:46 下午
 */
public class LeetCode107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 使用链表存储结果，使用头插法添加元素
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        // 队列
        Deque<TreeNode> queue = new LinkedList();
        // 插入根节点
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 存放每一层节点的集合
            int levelSize = queue.size();
            // 当前队列size，需要取好，因为队列在不断变化
            List<Integer> level = new ArrayList<>(8);
            //遍历队列
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // 每一层集合添加值
                level.add(node.val);
                // 左孩子
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 右孩子
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 头插法插入每一层节点集合
            result.addFirst(level);
        }
        return result;
    }

}
