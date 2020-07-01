package com.example.demo.threethread;

import java.util.concurrent.Semaphore;

/**
 * @author xueyu
 * @date 2020/6/28 22:13
 */
class Thread2 {
    private static volatile int index = 0;


    public static void main(String[] args) throws Exception {
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);

        Thread t1 = new Thread(() -> {
            try {
                while (index < 75) {
                    for (int i = 0; i < 5; i++) {
                        index++;
                        System.out.println(Thread.currentThread().getName() + "  " + index);
                    }
                    s2.release();
                    s1.acquire();
                }
                return;
            } catch (Exception e) {

            }

        });
        Thread t2 = new Thread(() -> {
            try {
                while (index < 75) {
                    s2.acquire();
                    for (int i = 0; i < 5; i++) {
                        index++;
                        System.out.println(Thread.currentThread().getName() + "  " + index);
                    }
                    s3.release();
                }
                return;
            } catch (Exception e) {

            }

        });
        Thread t3 = new Thread(() -> {

            try {
                while (index < 75) {
                    s3.acquire();
                    for (int i = 0; i < 5; i++) {
                        index++;
                        System.out.println(Thread.currentThread().getName() + "  " + index);
                    }
                    s1.release();
                }
                return;
            } catch (Exception e) {

            }
        });

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(10000);
    }
}
