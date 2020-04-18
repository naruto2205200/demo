package com.example.singleton;

/**
 * 双重检查锁定：对safeLazyInitialization的进一步优化
 * @author naruto
 * @data 2019/2/9.
 */
public class DoubleCheckedLocking {

    private static Instance instance;

    /**
     * 第一次检查时如果为null，在多线程环境还是会出现synchronized 的资源争抢，导致性能下降
     * @return
     */
    public static Instance getInstance() {
        if (instance == null) {//第一次检查
            synchronized (DoubleCheckedLocking.class) {
                if (instance == null) {//第二次检查
                    instance = new Instance();
                }
            }
        }
        return instance;
    }
}
