package com.imooc.miaosha.redis;

import java.util.List;
import java.util.Map;

/**
 * @author Richard_yyf
 * @version 1.0 2018/10/18
 */
public interface JedisDao {


    /**
     * 为给定 key 设置生存时间，当 key 过期时(生存时间为 0 )，它会被自动删除
     *
     * @param key    键
     * @param second 时间(单位：s)
     * @return 处理结果 成功 1， 失败 0
     * @author chenlw  v1.0   2017/11/22
     */
    long expire(String key, int second);

    /**
     * 以秒为单位，返回给定 key 的剩余生存时间
     *
     * @param key 键
     * @return 剩余时间
     * 当 key 不存在时，返回 -2 。
     * 当 key 存在但没有设置剩余生存时间时，返回 -1 。
     * 否则，以秒为单位，返回 key 的剩余生存时间。
     * @author chenlw  v1.0   2017/11/22
     */
    long ttl(String key);

    /**
     * 字符串类型(String) get 根据key获取value
     *
     * @param key 键
     * @return 值
     * @author chenlw  v1.0   2017/11/22
     */
    String get(String key);
    byte[] get(byte[] key);

    /**
     * 字符串类型(String) set
     * 将字符串值 value 关联到 key 。
     * 如果 key 已经持有其他值， SET 就覆写旧值，无视类型。
     * 对于某个原本带有生存时间（TTL）的键来说， 当 SET 命令成功在这个键上执行时， 这个键原有的 TTL 将被清除。
     *
     * @param key   键
     * @param value 值
     * @return 处理结果
     * 在 Redis 2.6.12 版本以前， SET 命令总是返回 OK 。
     * 从 Redis 2.6.12 版本开始， SET 在设置操作成功完成时，才返回 OK
     * 如果设置了 NX 或者 XX ，但因为条件没达到而造成设置操作未执行，那么命令返回空批量回复（NULL Bulk Reply）
     * @author chenlw  v1.0   2017/11/22
     */
    String set(String key, String value);
    String set(byte[] key, byte[] value);

    long setnx(String key,String value);

    long setnx(byte[] key, byte[] value);

    /**
     * 字符串类型(String) incr 将 key 中储存的数字值增一
     *
     * @param key 键
     * @return 处理后的value
     * @author chenlw  v1.0   2017/11/22
     */
    long incr(String key);

    /**
     * 删除给定的一个或多个key
     *
     * @param key 键
     * @return 被删除 key 的数量
     * @author chenlw  v1.0   2017/11/22
     */
    long del(String... key);
    long del(byte[]... key);

    /**
     * 哈希类型(Hash) 返回哈希表 key 中给定域 field 的值
     *
     * @param hkey hashKey
     * @param key  key
     * @return 给定域的值。当给定域不存在或是给定 key 不存在时，返回 nil
     * @author chenlw  v1.0   2017/11/22
     */
    String hget(String hkey, String key);
    byte[] hget(byte[] hkey, byte[] key);

    /**
     * 哈希类型(Hash)
     * 将哈希表 key 中的域 field 的值设为 value 。
     * 如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作。
     * 如果域 field 已经存在于哈希表中，旧值将被覆盖。
     *
     * @param hkey  hKey
     * @param key   key
     * @param value value
     * @return 处理结果
     * 如果 field 是哈希表中的一个新建域，并且值设置成功，返回 1 。
     * 如果哈希表中域 field 已经存在且旧值已被新值覆盖，返回 0 。
     * @author chenlw  v1.0   2017/11/22
     */
    long hset(String hkey, String key, String value);
    long hset(byte[] hkey, byte[] key, byte[] value);

    /**
     * 哈希类型(Hash) 删除哈希表 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     *
     * @param hkey hkey
     * @param key  key
     * @return 被成功移除的域的数量，不包括被忽略的域
     * @author chenlw  v1.0   2017/11/22
     */
    long hdel(String hkey, String... key);
    long hdel(byte[] hkey, byte[]... key);

    /**
     * 返回哈希表 key 中，所有的域和值。
     *
     * @param hkey key
     * @return 以列表形式返回哈希表的域和域的值。若 key 不存在，返回空列表。
     * @author chenlw  v1.0   2017/11/28
     */
    Map<String, String> hgetall(String hkey);
    Map<byte[], byte[]> hgetall(byte[] hkey);

    /**
     * List
     * 将一个或多个值 value 插入到列表 key 的表头
     *
     * @param key    key
     * @param values values
     * @return 执行 LPUSH 命令后，列表的长度
     * @author chenlw  v1.0   2017/11/22
     */
    long lpush(String key, String... values);

    /**
     * List
     * 移除并返回列表 key 的头元素。
     *
     * @param key key
     * @return 列表的头元素。当 key 不存在时，返回 nil 。
     * @author chenlw  v1.0   2017/11/22
     */
    String lpop(String key);

    /**
     * List
     * 返回列表 key 中指定区间内的元素，区间以偏移量 start 和 stop 指定。
     * 下标(index)参数 start 和 stop 都以 0 为底，也就是说，以 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。
     * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
     *
     * @param key   key
     * @param start 开始下标
     * @param end   结束下标
     * @return 一个列表，包含指定区间内的元素。
     * @author chenlw  v1.0   2017/11/23
     */
    List<String> lrange(String key, long start, long end);
}
