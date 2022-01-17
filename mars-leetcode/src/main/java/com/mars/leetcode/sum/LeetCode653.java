package com.mars.leetcode.sum;

import com.mars.leetcode.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/17 2:27 下午
 */
public class LeetCode653 {

    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) { return false; }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

}
