package com.imooc.miaosha.redis;

import com.imooc.miaosha.utils.KryoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Protocol;

import java.nio.charset.Charset;
import java.util.*;

/**
 * @author Richard_yyf
 * @Date 2018/11/21
 * @Description
 */
public class JedisServiceImpl implements JedisService {

    @Autowired
    private JedisDao jedisDao;

    @Override
    public String get(String key) {
        return jedisDao.get(key);
    }

    @Override
    public <T> T getAndDeserialization(String key) {
        byte[] keyByte = key.getBytes(Charset.forName(Protocol.CHARSET));
        byte[] value = jedisDao.get(keyByte);
        if (value == null) {
            return null;
        }
        return KryoUtils.readClassAndObject(value);
    }

    @Override
    public String hget(String hkey, String key) {
        return jedisDao.hget(hkey, key);
    }

    @Override
    public <T> T hgetAndDeserialization(String hkey, String key) {
        byte[] value = jedisDao.hget(hkey.getBytes(Charset.forName(Protocol.CHARSET)), key.getBytes(Charset.forName(Protocol.CHARSET)));
        if (value == null) {
            return null;
        }
        return KryoUtils.readClassAndObject(value);
    }

    @Override
    public String set(String key, String value) {
        return jedisDao.set(key, value);
    }

    @Override
    public long setnx(String key, String value) {
        return jedisDao.setnx(key,value);
    }

    @Override
    public long setnx(byte[] key, byte[] value) {
        return jedisDao.setnx(key,value);
    }

    @Override
    public <T> String serializationAndSet(String key, T unSerializationValue) {
        return jedisDao.set(key.getBytes(Charset.forName(Protocol.CHARSET)), KryoUtils.writeClassAndObject(unSerializationValue));
    }

    @Override
    public Map<String, String> hgetall(String hkey) {
        return jedisDao.hgetall(hkey);
    }

    @Override
    public <T> Map<String, T> hgetallAndDeserializationForMap(String hkey) {
        Map<String, T> resultMap = new HashMap<>();
        Map<byte[], byte[]> add = jedisDao.hgetall(hkey.getBytes(Charset.forName(Protocol.CHARSET)));
        Set<byte[]> keys = add.keySet();
        for (byte[] bytes : keys) {
            resultMap.put(new String(bytes, Charset.forName(Protocol.CHARSET)),
                    KryoUtils.readClassAndObject(add.get(bytes)));
        }
        return resultMap;
    }

    @Override
    public <T> List<T> hgetallAndDeserializationForList(String hkey) {
        List<T> resultList = new ArrayList<>();
        Map<byte[], byte[]> add = jedisDao.hgetall(hkey.getBytes(Charset.forName(Protocol.CHARSET)));
        Set<byte[]> keys = add.keySet();
        for (byte[] bytes : keys) {
            resultList.add(KryoUtils.readClassAndObject(add.get(bytes)));
        }
        return resultList;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        return jedisDao.hset(hkey, key, value);
    }

    @Override
    public <T> long serializationAndHset(String hkey, String key, T value) {
        return jedisDao.hset(hkey.getBytes(Charset.forName(Protocol.CHARSET)),
                key.getBytes(Charset.forName(Protocol.CHARSET)),
                KryoUtils.writeClassAndObject(value));
    }

    @Override
    public long incr(String key) {
        return jedisDao.incr(key);
    }

    @Override
    public long expire(String key, int second) {
        return jedisDao.expire(key, second);
    }

    @Override
    public long ttl(String key) {
        return jedisDao.ttl(key);
    }

    @Override
    public long del(String... key) {
        return jedisDao.del(key);
    }

    @Override
    public long hdel(String hkey, String... key) {
        return jedisDao.hdel(hkey, key);
    }

    @Override
    public long lpush(String key, String... values) {
        return jedisDao.lpush(key, values);
    }

    @Override
    public String lpop(String key) {
        return jedisDao.lpop(key);
    }

    @Override
    public List<String> lrange(String key, long start, long end) {
        return jedisDao.lrange(key, start, end);
    }

    @Override
    public String getSet(String key, String value) {
        return jedisDao.getSet(key, value);
    }
}
