package com.mars.leetcode.tree.search;

import com.mars.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/9 10:33 下午
 */
public class LeetCode501 {

    int count = 0;

    int maxCount = 0;

    TreeNode pre = new TreeNode(0);

    List<Integer> res = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 左
        dfs(root.left);
        // 中
        if (root.val == pre.val) {
            // 如果和前一个相同，count++
            count++;
        } else {
            pre = root;
            count = 1;
        }
        if (count > maxCount) {
            res.clear();
            res.add(root.val);
            maxCount = count;
        } else if (maxCount == count) {
            res.add(root.val);
        }
        // 右
        dfs(root.right);
    }

}
