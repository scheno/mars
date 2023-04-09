package com.mars.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/3/18 9:41 上午
 */
public class ConcurrentMap {

    public static final Map<String, String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (map.get("a") == null) {
            }
        }).start();
        Thread.sleep(10);
        new Thread(() -> map.put("a", "a")).start();
    }
}
