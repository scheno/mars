package com.mars.common.ratelimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author shenchen
 * @version 1.0
 * @date 2023/2/20 16:58
 */
public class IRateLimiterLock implements IRateLimiter {

    private int limit;

    private Map<String, Integer> resourceCounter;

    private ScheduledExecutorService scheduledExecutorService;

    @Override
    public synchronized boolean isAllow(String resource) throws InterruptedException {
        resourceCounter.putIfAbsent(resource, 0);
        int count = this.resourceCounter.get(resource) + 1;
        resourceCounter.put(resource, count);
        return count <= limit;
    }

    public IRateLimiterLock(int limit) {
        this.limit = limit;
        this.resourceCounter = new ConcurrentHashMap<>();
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        this.scheduledExecutorService.scheduleAtFixedRate(() -> {
            resourceCounter.clear();
        }, 0, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        IRateLimiter iRateLimiter = new IRateLimiterLock(5);
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                try {
                    boolean result = iRateLimiter.isAllow("A");
                    if (result) System.out.println(result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
