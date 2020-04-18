package com.example.singleton;

/**
 * 基于类初始化的解决方案
 * @author naruto
 * @data 2019/2/9.
 */
public class InstanceFactory {
    private static class InstanceHolder{
        public static Instance instance = new Instance();
    }

    public static Instance getInstance(){
        return InstanceHolder.instance;
    }
}
