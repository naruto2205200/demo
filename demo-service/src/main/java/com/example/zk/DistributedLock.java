package com.example.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author naruto
 * @data 2019/3/10.
 */
public class DistributedLock implements Watcher,Lock {

    private ZooKeeper zk = null;
    //定义根结点
    private String ROOT_LOCK = "/locks1";
    //等待前一个锁
    private String WAIT_LOCK;
    //表示当前的锁
    private String CURRENT_LOCK;
    //
    private CountDownLatch countDownLatch;

    public DistributedLock(){
        try {
            zk = new ZooKeeper("127.0.0.1:2181",4000, this);
            //判断根节点是否存在
            Stat stat = zk.exists(ROOT_LOCK, false);
            if (stat == null) {
                zk.create(ROOT_LOCK, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (this.countDownLatch != null) {
            this.countDownLatch.countDown();
        }
    }

    @Override
    public void lock() {
        //获得锁成功
        if (this.tryLock()) {
            return;
        }
        //没有获得锁则继续等待
        try {
            waitForLock(WAIT_LOCK);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //持续阻塞获取锁的方法
    private boolean waitForLock(String wait_lock) throws KeeperException, InterruptedException {
        //监听当前节点的上一个节点
        Stat stat = zk.exists(wait_lock, true);
        if (stat != null) {
            //计数器，等待直到释放锁
            countDownLatch = new CountDownLatch(1);
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName()+",获得锁");
        }
        return true;
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        try {
            //创建临时有序节点
            CURRENT_LOCK  = zk.create(ROOT_LOCK + "/", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(Thread.currentThread().getName()+"->"+CURRENT_LOCK+",尝试竞争锁");

            List<String> zkChildren = zk.getChildren(ROOT_LOCK, false);
            //定义一个有序集合进行排序
            SortedSet<String> sortedSet = new TreeSet<>();
            for (String chilren : zkChildren) {
                sortedSet.add(chilren);
            }

            //获取最小节点
            String firstNode = sortedSet.first();
            SortedSet<String> lessThenMe = ((TreeSet<String>) sortedSet).headSet(CURRENT_LOCK);
            if (CURRENT_LOCK.equals(firstNode)) {
                return true;
            }
            if (!lessThenMe.isEmpty()) {
                //获取比当前节点更小的最后一个结点，设置给WATI_LOCK
                WAIT_LOCK = lessThenMe.last();
            }

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit){

        return false;
    }

    @Override
    public void unlock() {
        //释放锁
        try {
            zk.delete(CURRENT_LOCK, -1);
            CURRENT_LOCK=null;
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
