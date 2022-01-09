package com.mars.leetcode.tree.search;

import com.mars.leetcode.TreeNode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/9 4:39 下午
 */
public class LeetCode98 {

    private TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // 左子树
        boolean isLeftValid = isValidBST(root.left);
        if (!isLeftValid) {
            return false;
        }
        // 根
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        // 右子树
        boolean isRightValid = isValidBST(root.right);
        return isRightValid;
    }

}
