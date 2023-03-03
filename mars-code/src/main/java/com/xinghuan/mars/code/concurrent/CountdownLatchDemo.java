package com.xinghuan.mars.code.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/9/7 14:19
 */
public class CountdownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countdownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第" + finalI + "次执行");
                countdownLatch.countDown();
            }).start();
        }
        countdownLatch.await();
        System.out.println("都执行完啦开始打印日志");
    }

}
