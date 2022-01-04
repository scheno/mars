package com.xinghuan.mars.code.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/1/4 3:47 下午
 */
public class MapCode {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1, 1);
    }

}
