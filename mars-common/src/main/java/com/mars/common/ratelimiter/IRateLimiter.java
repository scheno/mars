package com.mars.common.ratelimiter;

/**
 * 用Java设计实现一个限流组件
 * 1.  网站或者API服务有可能被恶意访问导致不可用，为了防止流量过大，通常会有限流设计。
 * 2.  请实现一个 RateLimiter 类，包含 isAllow 方法。
 * 每个请求包含一个 resource 资源，如果resource 在 1 秒钟内有超过 N 次请求，就拒绝响应。
 * @author shenchen
 * @version 1.0
 * @date 2023/2/20 16:56
 */
public interface IRateLimiter {

    /**
     * 是否允许访问
     *
     * @param resource
     * @return
     */
    boolean isAllow(String resource) throws InterruptedException;

}
