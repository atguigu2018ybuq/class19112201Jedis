package com.atguigu.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

public class JedisPoolCodeTest {

    public static void main(String[] args) {

        // 1.准备连接信息
        String ipAddress = "192.168.41.100";
        int port = Protocol.DEFAULT_PORT;

        // 2.创建连接池对象
        JedisPool jedisPool = new JedisPool(ipAddress, port);

        // 3.获取连接对象
        Jedis jedis = jedisPool.getResource();

        // 4.操作
        String ping = jedis.ping();
        System.out.println(ping);

        // 5.关闭连接
        jedis.close();

        // 6.关闭连接池
        jedisPool.close();
    }

}
