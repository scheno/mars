package com.mars.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/3/18 9:41 上午
 */
public class ConcurrentMap {

    public static Map<String, String> map = new ConcurrentHashMap<>();
//    public static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (map.get("a") == null) {
                i++;
            }
        }).start();
        Thread.sleep(10);
        new Thread(() -> {
            map.put("a", "a");
        }).start();
    }
}
