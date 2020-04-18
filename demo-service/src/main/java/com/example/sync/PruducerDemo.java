package com.example.sync;

/**
 * @author naruto
 * @data 2018/11/21.
 */
public class PruducerDemo implements Runnable{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        int count = 10;
        while (count > 0) {
            synchronized (Test.obj) {

                //System.out.print("count = " + count);
                System.out.println("A");
                count--;
                Test.obj.notify();

                try {
                    Test.obj.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
