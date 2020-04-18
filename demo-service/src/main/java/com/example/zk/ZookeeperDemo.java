package com.example.zk;


import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author naruto
 * @data 2019/3/4.
 */
public class ZookeeperDemo {
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);
    private static final String connectioning = "127.0.0.1:2181";
    private static final int sessionTimeout = 2000;
    public static void main(String[] args) throws IOException {
        ZooKeeper zkClient = new ZooKeeper(connectioning, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("触发事件");
            }
        });
//        zkClient.getData();
//        zkClient.setData()
//        zkClient.exists()
//        zkClient.getChildren()
    }


}
