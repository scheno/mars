package com.mars.leetcode.tree.path;

import com.mars.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/27 10:24 下午
 */
public class LeetCode257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) return null;
        backtracking(root, paths, path);
        return paths;
    }

    public void backtracking(TreeNode root, List<String> paths, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int num: path) {
                sb.append(num).append("->");
            }
            paths.add(sb.toString().substring(0, sb.length() - 2));
        }
        if (root.left != null) backtracking(root.left, paths, path);
        if (root.right != null) backtracking(root.right, paths, path);
        path.remove(path.size() - 1);
    }

    /**
     * @author shenchen
     * @version 1.0
     * @date 2022/1/7 5:29 下午
     */
    public static class LeetCode112 {

        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null && targetSum == root.val) {
                return true;
            }
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }
}
