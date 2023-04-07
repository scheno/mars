package com.mars.leetcode.tree.traversal;

import com.mars.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode145.二叉树的后序遍历
 * 
 * @author shenchen
 * @since 2021/12/18 12:34 上午
 */
public class LeetCode145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderList = new ArrayList<>();
        // 判断根节点是否为空
        if (root == null) {
            return postorderList;
        }
        // 定义一个栈
        Deque<TreeNode> stack = new LinkedList<>();
        // 将根节点压入栈中
        stack.push(root);
        // 处理栈中数据
        while (!stack.isEmpty()) {
            // 处理根节点数据
            TreeNode node = stack.pop();
            // 将节点数据添加到 list
            postorderList.add(node.val);
            // 处理左孩子
            if (node.right != null) {
                stack.push(node.right);
            }
            // 处理右孩子
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        // 反转list
        Collections.reverse(postorderList);
        return postorderList;
    }

}
