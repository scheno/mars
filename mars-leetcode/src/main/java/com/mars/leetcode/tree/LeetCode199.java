package com.mars.leetcode.tree;

import com.mars.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图
 *
 * 解题思路：二叉树层序遍历，处理每层最后一个
 * 特殊问题： 无
 *
 * @author shenchen
 * @version 1.0
 * @date 2022/1/1 10:46 下午
 */
public class LeetCode199 {

    public List<Integer> rightSideView(TreeNode root) {
        // 使用集合存储结果
        List<Integer> result = new ArrayList<>(16);
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
            //遍历队列
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // 处理最后一个节点
                if (i == levelSize - 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        // 插入每层最后一个元素
        return result;
    }

}
