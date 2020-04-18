package com.example.sync;

import java.util.concurrent.CountDownLatch;

/**
 * @author naruto
 * @data 2018/11/21.
 */
public class CountDownLatchDemo {
    static CountDownLatch count = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                count.countDown();//
                System.out.println(2);
                count.countDown();
            }
        }).start();
        count.await();


        System.out.println(3);
        System.out.println(4);
        System.out.println(5);

    }
}
