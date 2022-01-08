package com.mars.leetcode.tree.build;

import com.mars.leetcode.TreeNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/8 3:53 下午
 */
public class LeetCode106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd) {
        // 没有元素
        if (inEnd - inStart < 1) {
            return null;
        }
        // 只有一个元素
        if (inEnd - inStart == 1) {
            return new TreeNode(inorder[inStart]);
        }
        int rootVal = postorder[postEnd - 1];
        TreeNode node = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
            }
        }
        node.left = buildTree(inorder, inStart, rootIndex, postorder, postStart, postStart + (rootIndex - inStart));
        node.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postStart + (rootIndex - inStart), postEnd - 1);
        return node;
    }

}
