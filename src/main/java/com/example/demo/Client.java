package com.example.demo;

/**
 * @author xueyu
 * @date 2020/5/21 14:43
 */
public class Client {
    private static Object o = new Object();

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            synchronized (o) {
                System.out.println("1111");
                try {
                    Thread.sleep(2000);
                    o.notify();
                    System.out.println("1 wait...");
                    o.wait();
                }catch (Exception e){

                }
                System.out.println("1 end...");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (o) {
                try {
                    o.wait();
                    System.out.println("222");
                }catch (Exception e){

                }
            }
        });

        Thread t3 = new Thread(() -> {
            synchronized (o) {
                try {
                    o.wait();
                    System.out.println("333");
                }catch (Exception e){

                }
            }
        });


        t2.start();
        t3.start();
        Thread.sleep(1000);
        t1.start();

        Thread.sleep(10000);
    }
}
