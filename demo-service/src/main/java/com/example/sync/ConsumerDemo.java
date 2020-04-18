package com.example.sync;

/**
 * @author naruto
 * @data 2018/11/21.
 */
public class ConsumerDemo implements Runnable {
    @Override
    public synchronized void run() {
        // TODO Auto-generated method stub
        int count = 10;
        while(count > 0) {
            synchronized (Test. obj) {

                System. out.println( "B");
                count --;
                Test. obj.notify(); // 主动释放对象锁

                try {
                    Test. obj.wait();

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }
}
