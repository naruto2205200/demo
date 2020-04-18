package com.example.redis;

import com.jd.jim.cli.redis.jedis.HostAndPort;
import com.jd.jim.cli.redis.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author naruto
 * @data 2019/2/18.
 */
public class ClusterDemo {
    public static void main(String[] args) {
        Set<HostAndPort> set = new HashSet<>();
        set.add(new HostAndPort("192.168.1.1", 7001));
        set.add(new HostAndPort("192.168.1.2", 7001));
        JedisCluster jedisCluster = new JedisCluster(set);
        jedisCluster.set("", "");
        jedisCluster.hset("", "", "");
//        jedisCluster.setnx()
//        jedisCluster.setnx()
    }
}
