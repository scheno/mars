package com.xinghuan.mars.code.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/9/7 14:31
 */
public class ConditionWaitDemo implements Runnable {

    private Lock lock;

    private Condition condition;

    public ConditionWaitDemo(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("begin - ConditionDemoWait");
        lock.lock();
        try {
            condition.await();
            System.out.println("end - ConditionDemoWait");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}
