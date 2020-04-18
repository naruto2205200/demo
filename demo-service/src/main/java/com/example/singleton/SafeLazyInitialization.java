package com.example.singleton;

import sun.security.jca.GetInstance;

/**
 * @author naruto
 * @data 2019/2/9.
 */
public class SafeLazyInitialization {

    private static Instance instance;

    /**
     * synchronized 同步方法在多线程频繁调用会导致性能的下降
     * @return
     */
    public synchronized static Instance getInstance(){
        if (instance == null) {
            instance = new Instance();
        }
        return instance;
    }
}
