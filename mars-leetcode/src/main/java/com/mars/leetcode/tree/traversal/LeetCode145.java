package com.mars.leetcode.tree.traversal;

import com.mars.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/18 12:34 上午
 */
public class LeetCode145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return postorderList;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            postorderList.add(cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        // 反转list
        Collections.reverse(postorderList);
        return postorderList;
    }

}
