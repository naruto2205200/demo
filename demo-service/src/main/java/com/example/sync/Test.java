package com.example.sync;

/**
 * @author naruto
 * @data 2018/11/21.
 */
public class Test {
    public static final Object obj = new Object();

    public static void main(String[] args) {

        new Thread( new PruducerDemo()).start();
        new Thread( new ConsumerDemo()).start();

    }
}
