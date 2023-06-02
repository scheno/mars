package com.mars.common;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author shenchen
 * @version 1.0
 * @date 2023/3/15 17:26
 */
public class ClientWorker {

    private String agentName = "ClientWorker";

    private double currentLongingTaskCount = 0;

    private volatile Integer taskId = 0;

    private final ScheduledExecutorService executor;

    private final ScheduledExecutorService executorService;

    public ClientWorker() {
        this.executor = Executors.newScheduledThreadPool(1, (r) -> {
            Thread t = new Thread(r);
            t.setName("com.alibaba.nacos.client.Worker");
            t.setDaemon(true);
            return t;
        });

        // 创建 executorService 线程池，只完成了初始化，后续会用到，主要用于实现客户端的定时长轮询功能
        this.executorService = Executors
                .newScheduledThreadPool(Runtime.getRuntime().availableProcessors(),
                        (r) -> {
                            Thread t = new Thread(r);
                            t.setName("com.alibaba.nacos.client.Worker.longPolling." + agentName);
                            t.setDaemon(true);
                            return t;
                        });
        this.executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    if (2 > currentLongingTaskCount) {
                        checkConfigInfo(taskId);
                        taskId++;
                        currentLongingTaskCount++;
                    }
                } catch (Throwable e) {
                    System.out.println("[" + agentName + "] [sub-check] rotate check error");
                }
            }
        }, 1, 10, TimeUnit.MILLISECONDS);
    }

    public void checkConfigInfo(int taskId) {
        System.out.println("executor定时任务执行" + taskId);
        executorService.execute(new LongPollingRunnable(taskId));
    }

    class LongPollingRunnable implements Runnable {

        private final int taskId;

        public LongPollingRunnable(Integer taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(10000);
                System.out.println("executorService定时任务执行" + taskId);
                executorService.execute(this);
            } catch (Throwable e) {
                System.out.println("任务异常啦");
                executorService.schedule(this, 100L, TimeUnit.MILLISECONDS);
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ClientWorker clientWorker = new ClientWorker();
        Thread.sleep(10000000);
    }

}
