package com.mars.leetcode.tree.traversal;

import com.mars.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/17 10:21 下午
 */
public class LeetCode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> postorderList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.getFirst();
            if(root.right != null) {
                stack.push(root.right);
            } else {
                root = stack.pop();
                postorderList.add(root.val);
            }


        }
        return postorderList;
    }

}
