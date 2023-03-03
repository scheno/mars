package com.xinghuan.mars.code.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/9/7 14:31
 */
public class ConditionSignalDemo implements Runnable {

    private Lock lock;

    private Condition condition;

    public ConditionSignalDemo(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("begin - ConditionDemoSignal");
        lock.lock();
        try {
            Thread.sleep(1000);
            condition.signal();
            System.out.println("end - ConditionDemoSignal");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ConditionWaitDemo conditionWaitDemo = new ConditionWaitDemo(lock, condition);
        ConditionSignalDemo conditionSignalDemo = new ConditionSignalDemo(lock, condition);
        new Thread(conditionWaitDemo).start();
        new Thread(conditionSignalDemo).start();
    }
}
