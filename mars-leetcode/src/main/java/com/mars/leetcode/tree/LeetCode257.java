package com.mars.leetcode.tree;

import com.mars.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/27 10:24 下午
 */
public class LeetCode257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>(32);
        if (root == null) {
            return result;
        }
        LinkedList path = new LinkedList();
        traversal(root, path, result);
        return result;
    }

    public void traversal(TreeNode root, LinkedList path, List<String> result) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                builder.append(path.get(i));
                builder.append("-->");
            }
            builder.append(path.get(path.size() - 1));
            result.add(builder.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, path, result);
            path.removeFirst();
        }
        if (root.right != null) {
            traversal(root.right, path, result);
            path.removeFirst();
        }
    }

    public static void main(String[] args) {

    }
}
