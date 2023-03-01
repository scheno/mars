package com.xinghuan.mars.code.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static Integer count = 1;

    static ReentrantLock lock = new ReentrantLock();

    public static void inc() {
        lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> ReentrantLockDemo.inc()).start();
        }
        Thread.sleep(3000);
        System.out.println(count);
    }
}
