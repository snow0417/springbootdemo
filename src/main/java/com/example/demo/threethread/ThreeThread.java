package com.example.demo.threethread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author xueyu
 * @date 2020/6/28 22:13
 */
class ThreeThread {
    private static volatile int index = 0;
    private static Object lock = new Object();
    private static volatile int lockIndex = 1;

    public static void main(String[] args) throws Exception{
        CyclicBarrier barrier1 = new CyclicBarrier(1);
        CyclicBarrier barrier2 = new CyclicBarrier(1);

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    while (index < 75) {
                        if(lockIndex == 1){
                            for (int i = 0; i < 5; i++) {
                                index++;
                                System.out.println(Thread.currentThread().getName() + "  " + index);
                            }
                            lockIndex = 2;
                        }
                        lock.notifyAll();
                        lock.wait();
                    }
                    return;
                } catch (Exception e) {

                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    while (index < 75) {
                        if(lockIndex == 2){
                            for (int i = 0; i < 5; i++) {
                                index++;
                                System.out.println(Thread.currentThread().getName() + "  " + index);
                            }
                            lockIndex = 3;
                        }
                        lock.notifyAll();
                        lock.wait();
                    }
                    return;
                } catch (Exception e) {

                }
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized (lock) {
                try {
                    while (index < 75) {
                        if(lockIndex == 3){
                            for (int i = 0; i < 5; i++) {
                                index++;
                                System.out.println(Thread.currentThread().getName() + "  " + index);
                            }
                            lockIndex = 1;
                        }
                        lock.notifyAll();
                        lock.wait();
                    }
                    return;
                } catch (Exception e) {

                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        Semaphore semaphore = new Semaphore(0);
        Thread.sleep(10000);
    }
}
