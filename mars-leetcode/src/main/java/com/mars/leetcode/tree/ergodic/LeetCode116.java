package com.mars.leetcode.tree.ergodic;

import com.mars.leetcode.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LeetCode116.填充每个节点的下一个右侧节点指针
 * 
 * @author shenchen
 * @since 2022/1/3 8:40 下午
 */
public class LeetCode116 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if (i < levelSize - 1) {
                    node.next = queue.peek();
                } else {
                    node.next = null;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

}
