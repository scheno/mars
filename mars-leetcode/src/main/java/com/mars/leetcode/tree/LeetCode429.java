package com.mars.leetcode.tree;

import com.mars.leetcode.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/3 8:22 下午
 */

public class LeetCode429 {

    List<List<Integer>> result;

    public List<List<Integer>> levelOrder(Node root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 定义双端队列
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 定义队列大小
            int levelSize = queue.size();
            // 定义当前层级
            List<Integer> level = new ArrayList<>();
            // 遍历队列节点
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                level.add(node.val);
                // 处理子节点
                for (Node child: node.children) {
                    queue.offer(child);
                }
            }
            result.add(level);
        }
        return result;
    }

}
