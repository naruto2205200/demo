package com.example.singleton;

/**
 * 基于volatile关键字对双重检查的优化的解决方案，实现线程安全的延迟初始化
 * @author naruto
 * @data 2019/2/9.
 */
public class SafeDoubleCheckedLocking {

    private volatile static Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (SafeDoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }
}
