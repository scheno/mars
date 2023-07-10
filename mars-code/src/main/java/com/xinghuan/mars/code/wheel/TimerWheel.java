package com.xinghuan.mars.code.wheel;

import io.micrometer.core.instrument.util.NamedThreadFactory;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author shenchen
 * @since 2023/7/10 15:28
 */
@SuppressWarnings("all")
public class TimerWheel implements IWheel {

    private final ConcurrentHashMap<Long, ITask>[] wheel; // 轮子
    private final int wheelSize; // 轮子大小
    private final AtomicInteger currentOffset; // 当前偏移量
    private final AtomicLong nextId = new AtomicLong(System.currentTimeMillis()); // 任务编号;
    private static final int nThreads = Runtime.getRuntime().availableProcessors();
    private final ThreadPoolExecutor executor;

    /**
     * 构造方法
     *
     * @param wheelSize  轮子个数
     * @param threadName 线程名字
     */
    public TimerWheel(int wheelSize, String threadName) {
        ThreadFactory threadFactory = new NamedThreadFactory(threadName);
        int firstOffset = 0;
        this.wheelSize = wheelSize;
        this.wheel = new ConcurrentHashMap[wheelSize];
        this.currentOffset = new AtomicInteger(firstOffset);
        this.executor = new ThreadPoolExecutor(nThreads, nThreads, 0, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), threadFactory);
        for (int i = 0; i < wheelSize; i++) {
            this.wheel[i] = new ConcurrentHashMap<Long, ITask>();
        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                int offsetValue = currentOffset.getAndIncrement();
                int pointer = offsetValue % wheelSize; // 指针
                Map<Long, ITask> slot = wheel[pointer];
                if (!slot.isEmpty()) {
                    slot.entrySet().removeIf(entry -> {
                        ITask task = entry.getValue();
                        long time = task.getOffset() - offsetValue;
                        boolean result = time == 0;
                        if (result) {
                            executor.submit(task);
                        }
                        return result;
                    });
                }
            }
        }, firstOffset, 1000);
    }

    @Override
    public String addTask(ITask task, Integer delayedTime) {
        long taskId = nextId.getAndIncrement();
        int offset = delayedTime + currentOffset.get();
        task.setOffset(offset);
        int slotIndex = offset % wheelSize;
        wheel[slotIndex].put(taskId, task);
        return "task-" + Integer.toString(slotIndex, 32) + "-" + Long.toString(taskId, 32);
    }

    @Override
    public boolean removeTask(String taskId) {
        if (taskId != null && taskId.trim().isEmpty()) {
            String[] arr = taskId.split("-");
            if (arr.length == 3) {
                int slotIndex = Integer.valueOf(arr[1], 32);
                Map<Long, ITask> slot = wheel[slotIndex];
                if (!slot.isEmpty()) {
                    long key = Long.valueOf(arr[2], 32);
                    slot.remove(key);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String delayedTask(String taskId, Integer delayedTime) {
        if (taskId != null && !taskId.trim().isEmpty()) {
            String[] arr = taskId.split("-");
            if (arr.length == 3) {
                int slotIndex = Integer.valueOf(arr[1], 32);
                Map<Long, ITask> slot = wheel[slotIndex];
                if (!slot.isEmpty()) {
                    long key = Long.valueOf(arr[2], 32);
                    ITask task = slot.remove(key);
                    if (task != null) {
                        return addTask(task, delayedTime);
                    }
                }
            }
        }
        return null;
    }
}
