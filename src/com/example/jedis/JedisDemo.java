package com.example.jedis;


import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class JedisDemo {

    public static void main(String[] args) {

        //java连接redis
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        System.out.println("运行" + jedis.ping());
        jedis.set("ss", "123");
        jedis.get("ss");
        System.out.println("ss:" + jedis.get("ss"));

        //存储数据到列表中
        jedis.lpush("language", "Python2");
        jedis.lpush("language", "C++");
        jedis.lpush("language", "Perl");

        // 获取存储的数据并输出
        List<String> list = jedis.lrange("language", 0, 2);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表项为: " + list.get(i));
        }


        Set<String> keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key);
        }

    }
}
