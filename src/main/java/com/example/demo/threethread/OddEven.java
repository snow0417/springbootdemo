package com.example.demo.threethread;

/**
 * @author xueyu
 * @date 2020/6/29 16:36
 */
public class OddEven {
    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(6);
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.even();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(10000);
    }







    public static class ZeroEvenOdd {
        private int n;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        private Object o = new Object();

        private volatile int nowTIndex = 1;

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero() throws InterruptedException {
            synchronized (o) {
                for (int i = 1; i <= n; i++) {
                    while (nowTIndex != 1) {
                        o.wait();
                    }
                    System.out.print(0);
                    if (i % 2 == 0) {
                        nowTIndex = 2;
                    } else {
                        nowTIndex = 3;
                    }
                    o.notifyAll();
                }
            }
            System.out.println("thread 1 exit.");
        }

        public void even() throws InterruptedException {
            synchronized (o) {
                for (int i = 2; i <= n; i = i + 2) {
                    while (nowTIndex != 2) {
                        o.wait();
                    }
                    System.out.print(i);
                    nowTIndex = 1;
                    o.notifyAll();
                }
            }
            System.out.println("thread 2 exit.");
        }

        public void odd() throws InterruptedException {
            synchronized (o) {
                for (int i = 1; i <= n; i = i +2) {
                    while (nowTIndex != 3) {
                        o.wait();
                    }
                    System.out.print(i);
                    nowTIndex = 1;
                    o.notifyAll();
                }
            }
            System.out.println("thread 3 exit.");
        }
    }
}
