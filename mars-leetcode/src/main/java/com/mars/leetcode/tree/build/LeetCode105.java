package com.mars.leetcode.tree.build;

import com.mars.leetcode.TreeNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/8 8:30 下午
 */
public class LeetCode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // 递归终止条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 根结点值
        int rootVal = preorder[preStart];
        // 构建根节点
        TreeNode root = new TreeNode(rootVal);
        // 根结点下标
        int rootIndex = inStart;
        for (int i = inStart; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        root.left = buildTree(preorder, preStart + 1, preStart + (rootIndex - inStart), inorder, inStart, rootIndex - 1);
        root.right = buildTree(preorder, preStart + (rootIndex - inStart) + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }

}
