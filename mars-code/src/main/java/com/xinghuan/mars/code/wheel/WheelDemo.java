package com.xinghuan.mars.code.wheel;

import java.util.Random;

/**
 * @author shenchen
 * @since 2023/7/10 15:28
 */
public class WheelDemo {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        IWheel iWheel = new TimerWheel(60, "Wheel-1");
        String taskId = iWheel.addTask(new ITask() {
            @Override
            public void run() {
                System.out.println("测试任务执行");
            }
        }, random.nextInt(10) + 10);
        System.out.println(taskId);

        Thread.sleep(100000);

    }

}
