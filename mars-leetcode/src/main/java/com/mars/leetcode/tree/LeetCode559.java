package com.mars.leetcode.tree;

import com.mars.leetcode.Node;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/3 9:37 下午
 */
public class LeetCode559 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int childDepth = maxDepth(root.children.get(i));
            maxDepth = Math.max(childDepth, maxDepth);
        }
        return maxDepth + 1;
    }

}
