package com.mars.leetcode.tree.depth;

import java.util.List;

import com.mars.leetcode.Node;

/**
 * LeetCode559.N 叉树的最大深度
 * 
 * @author shenchen
 * @since 2023-04-08 23:34
 */
public class LeetCode559 {
    
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        List<Node> children = root.children;
        for (Node node : children) {
            int depth = maxDepth(node);
            maxDepth = Math.max(maxDepth, depth);
        }

        return maxDepth + 1;
    }

}
