package com.mars.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/30 1:50 下午
 */

class LRUCache {

    class Node {
        Integer key;
        Integer value;
        Node prev, next;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Integer capacity;

    private Map<Integer, Node> map;

    private Node head;

    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            addToHead(node);
            map.put(key, node);
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

}

public class LeetCode146 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(3, 2);
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 3);
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));

    }
}
