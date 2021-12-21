package com.mars.leetcode.tree;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/20 8:03 下午
 */


public class MultiThreadPrint {

    private static Object A = new Object();
    private static Object B = new Object();
    private static Object C = new Object();

    static class ThreadA extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (A) {
                    try {
                        System.out.println("A");
                        synchronized (B) {
                            B.notify();
                        }
                        A.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    static class ThreadB extends Thread {

        @Override
        public void run() {

            while (true) {
                synchronized (B) {
                    try {
                        System.out.println("B");
                        synchronized (C) {
                            C.notify();
                        }
                        B.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class ThreadC extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (C) {
                    try {
                        System.out.println("C");
                        synchronized (A) {
                            A.notify();
                        }
                        C.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.start();
        Thread.sleep(10);
        ThreadB threadB = new ThreadB();
        threadB.start();
        Thread.sleep(10);
        ThreadC threadC = new ThreadC();
        threadC.start();
        Thread.sleep(10);
    }
}
