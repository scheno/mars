package com.mars.common;

import java.util.concurrent.Semaphore;

/**
 * @author shenchen
 * @version 1.0
 * @date 2023/2/17 16:43
 */
public class SemaphoreDemo {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "进入停车场");
                try {
                    semaphore.acquire(1);
                    System.out.println(Thread.currentThread().getName() + "正在停车");

                    Thread.sleep(1000);
                    semaphore.release(1);
                    System.out.println(Thread.currentThread().getName() + "离开停车场");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "第" + i + "车").start();
        }
    }

}
