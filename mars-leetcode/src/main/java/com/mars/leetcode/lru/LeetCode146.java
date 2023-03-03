package com.mars.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/30 1:50 下午
 */
class LRUCache {

    private int capacity;

    private Node dummy;

    private Node tail;

    private Map<Integer, Node> map;

    class Node {

        int key;
        int value;
        Node prev, next;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        if (capacity < 1) {
            throw new RuntimeException("capacity must > 1");
        }
        map = new HashMap<>(capacity);
        this.capacity = capacity;

        dummy = new Node();
        tail = new Node();
        // 初始化前后节点，避免为空.next为空
        dummy.next = tail;
        tail.prev = dummy;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            moveToTail(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToTail(node);
        } else {
            node = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(dummy.next.key);
                removeNode(dummy.next);
            }

            map.put(node.key, node);
            addToTail(node);
        }
    }

    public void addToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToTail(Node node) {
        removeNode(node);
        addToTail(node);
    }

}

public class LeetCode146 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 0);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));

    }
}
