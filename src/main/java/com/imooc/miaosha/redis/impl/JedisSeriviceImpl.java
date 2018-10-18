package com.imooc.miaosha.redis.impl;

import com.imooc.miaosha.redis.JedisDao;
import com.imooc.miaosha.redis.JedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Richard_yyf
 * @version 1.0 2018/10/18
 */
@Service(value = "jedisService")
public class JedisSeriviceImpl implements JedisService {

    @Autowired
    private JedisDao jedisDao;
    
    @Override
    public String set(String key, String value) {
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
    public <T> String serializationAndSet(String key, T unSerializationValue) {
        return null;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        return 0;
    }

    @Override
    public <T> long serializationAndHset(String hkey, String key, T value) {
        return 0;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public <T> T getAndDeserialization(String key) {
        return null;
    }

    @Override
    public String hget(String hkey, String key) {
        return null;
    }

    @Override
    public <T> T hgetAndDeserialization(String hkey, String key) {
        return null;
    }

    @Override
    public Map<String, String> hgetall(String hkey) {
        return null;
    }

    @Override
    public <T> Map<String, T> hgetallAndDeserializationForMap(String hkey) {
        return null;
    }

    @Override
    public <T> List<T> hgetallAndDeserializationForList(String hkey) {
        return null;
    }

    @Override
    public long incr(String key) {
        return 0;
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
    public long del(String... key) {
        return 0;
    }

    @Override
    public long hdel(String hkey, String... key) {
        return 0;
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
