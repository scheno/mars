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

        public Node() {
        }

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    Integer size;

    Integer capacity;

    Map<Integer, Node> cache = new HashMap<>();

    Node dummy;

    Node tail;

    public LRUCache() {
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        dummy = new Node();
        tail = new Node();
        dummy.next = tail;
        tail.prev = dummy;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);
            size += 1;
            if (size > capacity) {
                Node tail = removeTail();
                cache.remove(tail.key);
                size -= 1;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void addToHead(Node node) {
        node.prev = dummy;
        node.next = dummy.next;
        dummy.next.prev = node;
        dummy.next = node;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
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
