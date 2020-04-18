package com.example.sync;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author naruto
 * @data 2019/2/9.
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
//        lock.wait();
    }


    static class Wait implements Runnable{
        @Override
        public void run() {
            //加锁，拥有lock的Monitor
            synchronized (lock) {
                //当条件不满足时继续wait，同时释放lock的锁
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread()+" flag is true .wait @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //条件满足时，完成工作
                System.out.println(Thread.currentThread()+" flag is false, running @"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    lock.notify();
                    flag = false;
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (lock) {

            }
        }
    }


}
