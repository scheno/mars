package com.mars.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.mars.leetcode.TreeNode;

/**
 * LeetCode222.完全二叉树的节点个数
 * 
 * @author shenchen
 * @since 2023-03-08 23:42
 */
public class LetCode222 {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                result++;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return result;
    }
    
}
