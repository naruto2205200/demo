package com.example.sync;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author naruto
 * @data 2019/2/11.
 */
public class ExchangeDemo {

    public static void main(String[] args) {
        Exchanger<String> exgr = new Exchanger<>();

        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(new Runnable() {
            @Override
            public void run() {
                String data1 = "这是data1";

                try {
                    String exchange = exgr.exchange(data1);
                    System.out.println("线程1"+exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                String data2 = "这是data2";
                try {
                    String exchange = exgr.exchange(data2);
                    System.out.println("线程2"+exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
