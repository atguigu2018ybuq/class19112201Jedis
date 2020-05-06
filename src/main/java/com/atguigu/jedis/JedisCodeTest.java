package com.atguigu.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Protocol;

import java.util.List;

public class JedisCodeTest {

    public static void main(String[] args) {

        // 1.准备连接信息
        String ipAddress = "192.168.41.100";
        int port = Protocol.DEFAULT_PORT;

        // 2.创建连接对象
        Jedis jedis = new Jedis(ipAddress, port);

        // 3.调用Jedis对象的方法操作Redis服务器
        String ping = jedis.ping();

        System.out.println(ping);

        Long pushResult = jedis.lpush("animal", "cat", "dog", "tiger", "pig");

        System.out.println("lpush结果="+pushResult);

        List<String> animalList = jedis.lrange("animal", 0, -1);

        for (String animal : animalList) {
            System.out.println(animal);
        }

        // 4.关闭连接
        jedis.close();

        // 在feature-good分支所做修改
    }

}
