package com.mars.common;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author shenchen
 * @version 1.0
 * @date 2023/2/17 16:34
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("人到齐了，老板宣布开始开会");
        });

        for (int i = 0; i < 5; i++) {
            System.out.println("第" + i + "个人到了");
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
