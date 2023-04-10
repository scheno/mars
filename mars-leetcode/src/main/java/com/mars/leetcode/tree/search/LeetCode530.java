package com.mars.leetcode.tree.search;

import com.mars.leetcode.TreeNode;

/**
 * LeetCode530.二叉搜索树的最小绝对差
 * 
 * @author shenchen
 * @since 2022/1/9 10:12 下午
 */
public class LeetCode530 {

    TreeNode pre;

    Integer res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMinimumDifference(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        getMinimumDifference(root.right);
        return res;
    }

}
