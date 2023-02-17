package com.mars.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author shenchen
 * @version 1.0
 * @date 2023/2/17 10:46
 */
public class ReentrantLockDemo {

    private volatile List list = new ArrayList();

    public void add(Object value) {
        list.add(value);
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {
        ReentrantLockDemo question = new ReentrantLockDemo();

        Object lock = new Object();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " 启动");
                if (question.getSize() != 5) {
                    try {
                        lock.wait();
                        System.out.println(Thread.currentThread().getName() + " 结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "t2");

        new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " 启动");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    question.add(i);
                    if (question.getSize() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "t1");

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 启动");
            if (question.getSize() != 5) {
                try {
                    countDownLatch.await();
                    System.out.println(Thread.currentThread().getName() + " 结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 启动");
            for (int i = 0; i < 10; i++) {
                question.add(i);
                System.out.println(i);
                if (question.getSize() == 5) {
                    System.out.println("countdown is open");
                    countDownLatch.countDown();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("t1 结束");
        }, "t1").start();
    }

}
