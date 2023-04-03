package com.mars.leetcode.tree.traversal;

import com.mars.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * 先序遍历：中 -> 左 -> 右
 * 中序遍历：左 -> 中 -> 右
 * 后续遍历：左 -> 右 -> 中
 *
 * @author shenchen
 * @version 1.0
 * @date 2021/12/17 10:21 下午
 */
public class LeetCode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList();
        while(root != null || !stack.isEmpty()) {
            // 如果当前节点不为空，那可能存在左侧节点，继续寻找左侧节点
            if (root != null) {
                // 将遍历的节点放入栈中
                stack.push(root);
                // 继续寻找下个左节点
                root = root.left;
            // 如果当前节点为空的话，则有两种情况
            // 第一种情况是左侧节点，说明当前左节点处理完毕，开始处理中节点
            // 第二种情况是右侧节点，说明当前右，中节点已处理完毕，处理上一个节点
            } else {
                // 该节点无左侧节点时，说明该处理当前节点
                TreeNode node = stack.pop();
                inorderList.add(node.val);
                // 处理右侧节点
                root = root.right;
            }

        }
        return inorderList;
    }

}
