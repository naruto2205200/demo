package com.example.redis;

import com.jd.jim.cli.redis.jedis.Jedis;
import com.jd.jim.cli.redis.jedis.Tuple;

import java.util.Set;

/**
 * @author naruto
 * @data 2019/2/18.
 */
public class JedisDemo {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("127.0.0.1");
//        hashTest(jedis);
//        sortedSet(jedis);

        Set<String> keys = jedis.keys("*");
        for (int i = 0; i < 1000; i++) {
            jedis.sadd("myset", "hello" + i);
        }
//        System.out.println(keys);
    }

    public static void stringTest(Jedis jedis ){
        String mset = jedis.mset("hello", "hello1", "hello2", "hello2");
        System.out.println("======mset=====" + mset);
//        Long setnx = jedis.setnx("hello3", "hello3");
//        System.out.println("========setnx========"+setnx);
//        Long expire = jedis.expire("hello3", 10);
//        System.out.println("========expire======"+expire);
        Long ttl = jedis.ttl("hello3");
        System.out.println("=======ttl====="+ttl);
    }

    public static void hashTest(Jedis jedis) {
        jedis.hset("hhello1", "name1", "zhangsan1");
        jedis.hset("hhello2", "name2", "zhangsan2");
        System.out.println("=============hset======="+jedis.hkeys("hhello1"));

    }

    public static void sortedSet(Jedis jedis) {
        jedis.zadd("name", 1 , "zhangsan");
        jedis.zadd("name", 53, "lisi");
        jedis.zadd("name", 34, "wangwu");

        System.out.println("======"+jedis.zrange("name",0,-1));
        Double zscore = jedis.zscore("name", "lisi");
        System.out.println("======zscore"+zscore);

        System.out.println(jedis.zrange("name", 0, -1));
        Set<Tuple> tuples = jedis.zrangeByScoreWithScores("name", 0, 100);
        for (Tuple tuple : tuples) {
            System.out.println(tuple.getElement()+","+tuple.getScore()+","+tuple.getBinaryElement());
        }
        System.out.println();
    }
}
