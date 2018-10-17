package com.imooc.miaosha.redis;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Richard_yyf
 * @Date 2018/10/17
 * @Description
 */

@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private RedisConfig redisConfig;

    public <T> T get(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = jedis.get(key);
            T t = strToBean(str);
        } finally {
            returntoPool(jedis);
        }
        return null;
    }

    public <T> boolean get(String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = beanToStr(value);
            if (StringUtils.isBlank(str)) {

            }
            jedis.set(key, str);
            return true;
        } finally {
            returntoPool(jedis);
        }
    }

    /**
     * 对象序列化成json字符创
     * @param value
     * @param <T>
     * @return
     */
    private <T> String beanToStr(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {

        } else if (clazz == String.class) {

        } else if (clazz == long.class || clazz == Long.class) {

        }
        return JSON.toJSONString(value);
    }

    /**
     * json 字符串 反序列化
     * @param str
     * @param <T>
     * @return
     */
    private <T> T strToBean(String str) {
        return null;
    }

    private void returntoPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    @Bean
    public JedisPool JedisFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        // 单位是毫秒
        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle() * 1000);
        // database字段 代表指定redis的16个库 0-15
        JedisPool jedisPool = new JedisPool(poolConfig, redisConfig.getHost(),
                redisConfig.getPort(), redisConfig.getTimeout() * 1000,
                redisConfig.getPassword(), 0);
        return jedisPool;
    }
}
