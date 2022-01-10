package com.mars.leetcode.tree.modify;

import com.mars.leetcode.TreeNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/11 12:37 上午
 */
public class LeetCode450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null && root.right != null) {
                return root.right;
            }
            if (root.left != null && root.right == null) {
                return root.left;
            }
            if (root.left != null && root.right != null) {
                TreeNode node = root.right;
                while (node.left != null) {
                    node = node.left;
                }
                node.left = root.left;
                TreeNode temp = root.right;
                root = root.right;
            }
        }
        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;
    }

}
