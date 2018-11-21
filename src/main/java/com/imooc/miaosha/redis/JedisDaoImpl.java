package com.imooc.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;

/**
 * @author Richard_yyf
 * @Date 2018/11/21
 * @Description
 */
public class JedisDaoImpl implements JedisDao{

    @Autowired
    private JedisPool jedisPool;

    @Override
    public String get(String key) {
        Jedis jedis = null;
        String string;
        try {
            jedis = jedisPool.getResource();
            string = jedis.get(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return string;
    }

    @Override
    public byte[] get(byte[] key) {
        Jedis jedis = null;
        byte[] value;
        try {
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return value;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = null;
        String string;
        try {
            jedis = jedisPool.getResource();
            string = jedis.set(key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return string;
    }

    @Override
    public String set(byte[] key, byte[] value) {
        Jedis jedis = null;
        String string;
        try {
            jedis = jedisPool.getResource();
            string = jedis.set(key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return string;
    }

    @Override
    public long setnx(String key, String value) {
        Jedis jedis = null;
        Long l;
        try {
            jedis = jedisPool.getResource();
            l = jedis.setnx(key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return l;
    }

    @Override
    public long setnx(byte[] key, byte[] value) {
        Jedis jedis = null;
        Long l;
        try {
            jedis = jedisPool.getResource();
            l = jedis.setnx(key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return l;
    }

    @Override
    public String hget(String hkey, String key) {
        Jedis jedis = null;
        String string;
        try {
            jedis = jedisPool.getResource();
            string = jedis.hget(hkey, key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return string;
    }

    @Override
    public byte[] hget(byte[] hkey, byte[] key) {
        Jedis jedis = null;
        byte[] value;
        try {
            jedis = jedisPool.getResource();
            value = jedis.hget(hkey, key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return value;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        Jedis jedis = null;
        Long result;
        try {
            jedis = jedisPool.getResource();
            result = jedis.hset(hkey, key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public long hset(byte[] hkey, byte[] key, byte[] value) {
        Jedis jedis = null;
        Long result;
        try {
            jedis = jedisPool.getResource();
            result = jedis.hset(hkey, key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public long incr(String key) {
        Jedis jedis = null;
        Long result;
        try {
            jedis = jedisPool.getResource();
            result = jedis.incr(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public long expire(String key, int second) {
        Jedis jedis = null;
        Long result;
        try {
            jedis = jedisPool.getResource();
            result = jedis.expire(key, second);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public long ttl(String key) {
        Jedis jedis = null;
        Long result;
        try {
            jedis = jedisPool.getResource();
            result = jedis.ttl(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public long del(String... key) {
        Jedis jedis = null;
        Long result;
        try {
            jedis = jedisPool.getResource();
            result = jedis.del(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public long del(byte[]... key) {
        Jedis jedis = null;
        Long result;
        try {
            jedis = jedisPool.getResource();
            result = jedis.del(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public long hdel(String hkey, String... key) {
        Jedis jedis = null;
        Long result;
        try {
            jedis = jedisPool.getResource();
            result = jedis.hdel(hkey, key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public long hdel(byte[] hkey, byte[]... key) {
        Jedis jedis = null;
        Long result;
        try {
            jedis = jedisPool.getResource();
            result = jedis.hdel(hkey, key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Map<String,String> hgetall(String hkey) {
        Jedis jedis = null;
        Map<String,String> result;
        try {
            jedis = jedisPool.getResource();
            result = jedis.hgetAll(hkey);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public Map<byte[], byte[]> hgetall(byte[] hkey) {
        Jedis jedis = null;
        Map<byte[], byte[]> result;
        try {
            jedis = jedisPool.getResource();
            result = jedis.hgetAll(hkey);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public long lpush(String key, String... values) {
        Jedis jedis = null;
        Long length;
        try {
            jedis = jedisPool.getResource();
            length = jedis.lpush(key, values);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return length;
    }

    @Override
    public String lpop(String key) {
        Jedis jedis = null;
        String result;
        try {
            jedis = jedisPool.getResource();
            result = jedis.lpop(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public List<String> lrange(String key, long start, long end) {
        Jedis jedis = null;
        List<String> lrange;
        try {
            jedis = jedisPool.getResource();
            lrange = jedis.lrange(key, start, end);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return lrange;
    }

    @Override
    public String flushall() {
        Jedis jedis = null;
        String result;
        try {
            jedis = jedisPool.getResource();
            result = jedis.flushAll();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    @Override
    public String getSet(String key, String value) {
        Jedis jedis = null;
        String result;
        try {
            jedis = jedisPool.getResource();
            result = jedis.getSet(key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }
}
