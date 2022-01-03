package com.mars.leetcode;

import java.util.List;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/3 8:22 下午
 */
public class Node {
    public int val;

    public Node left;

    public Node right;

    public Node next;

    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
