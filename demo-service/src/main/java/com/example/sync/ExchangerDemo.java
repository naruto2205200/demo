package com.example.sync;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author naruto
 * @data 2018/11/21.
 */
public class ExchangerDemo {

    private static Exchanger<String> exchanger = new Exchanger<>();

    private static Executor pool = Executors.newFixedThreadPool(2);
}
