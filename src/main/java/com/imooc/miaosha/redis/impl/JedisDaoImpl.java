package com.imooc.miaosha.redis.impl;

import com.imooc.miaosha.redis.JedisDao;
import com.imooc.miaosha.redis.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;

/**
 * @author Richard_yyf
 * @Date 2018/10/18
 * @Description
 */

@Repository(value = "jedisDao")
public class JedisDaoImpl implements JedisDao {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private RedisConfig redisConfig;

    @Bean
    public JedisPool jedisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        jedisPoolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        // 单位是毫秒
        jedisPoolConfig.setMaxIdle(redisConfig.getPoolMaxIdle() * 1000);
        // database字段 代表指定redis的16个库 0-15
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, redisConfig.getHost(),
                redisConfig.getPort(), redisConfig.getTimeout() * 1000,
                redisConfig.getPassword(), 0);
        return jedisPool;
    }

    @Override
    public long expire(String key, int second) {
        return 0;
    }

    @Override
    public long ttl(String key) {
        return 0;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public byte[] get(byte[] key) {
        return new byte[0];
    }

    @Override
    public String set(String key, String value) {
        return null;
    }

    @Override
    public String set(byte[] key, byte[] value) {
        return null;
    }

    @Override
    public long setnx(String key, String value) {
        return 0;
    }

    @Override
    public long setnx(byte[] key, byte[] value) {
        return 0;
    }

    @Override
    public long incr(String key) {
        return 0;
    }

    @Override
    public long del(String... key) {
        return 0;
    }

    @Override
    public long del(byte[]... key) {
        return 0;
    }

    @Override
    public String hget(String hkey, String key) {
        return null;
    }

    @Override
    public byte[] hget(byte[] hkey, byte[] key) {
        return new byte[0];
    }

    @Override
    public long hset(String hkey, String key, String value) {
        return 0;
    }

    @Override
    public long hset(byte[] hkey, byte[] key, byte[] value) {
        return 0;
    }

    @Override
    public long hdel(String hkey, String... key) {
        return 0;
    }

    @Override
    public long hdel(byte[] hkey, byte[]... key) {
        return 0;
    }

    @Override
    public Map<String, String> hgetall(String hkey) {
        return null;
    }

    @Override
    public Map<byte[], byte[]> hgetall(byte[] hkey) {
        return null;
    }

    @Override
    public long lpush(String key, String... values) {
        return 0;
    }

    @Override
    public String lpop(String key) {
        return null;
    }

    @Override
    public List<String> lrange(String key, long start, long end) {
        return null;
    }
}
