package com.imooc.miaosha.utils;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.pool.KryoFactory;
import com.esotericsoftware.kryo.pool.KryoPool;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Kryo 序列化工具
 *
 * @author Richard_yyf
 * @date 2018/10/18
 */
public class KryoUtils {


    private static volatile KryoFactory factory = () -> {
        Kryo kryo = new Kryo();
        // configure kryo instance, customize settings
        return kryo;
    };

    private static volatile KryoPool pool = new KryoPool.Builder(factory).softReferences().build();

    private KryoUtils() {
    }

    public static KryoPool getPool() {
        return pool;
    }

    /**
     * 将对象【及类型】序列化为字节数组
     *
     * @param obj 任意对象
     * @param <T> 对象的类型
     * @return 序列化后的字节数组
     */
    public static <T> byte[] writeClassAndObject(T obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Output output = new Output(byteArrayOutputStream);
        KryoPool pool = getPool();
        Kryo kryo = pool.borrow();
        kryo.writeClassAndObject(output, obj);
        output.flush();
        pool.release(kryo);
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * 将字节数组反序列化为原对象
     *
     * @param byteArray 待反序列化的字节数组
     * @param <T>       原对象的类型
     * @return 原对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T readClassAndObject(byte[] byteArray) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        Input input = new Input(byteArrayInputStream);
        KryoPool pool = getPool();
        Kryo kryo = pool.borrow();
        T res = (T) kryo.readClassAndObject(input);
        pool.release(kryo);
        return res;
    }

    /**
     * 将 String 反序列化为原对象
     *
     * @param str 待反序列化的字符串
     * @param <T> 原对象的类型
     * @return 原对象，当参数为 null 时，返回 null
     */
    public static <T> T readFromString(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return readClassAndObject(str.getBytes(StandardCharsets.UTF_8));
    }

    //-----------------------------------------------
    //          只序列化/反序列化对象
    //          序列化的结果里，不包含类型的信息
    //-----------------------------------------------

    /**
     * 将对象序列化为字节数组
     * @param obj 任意对象
     * @param <T> 对象的类型
     * @return 序列化后的字节数组
     */
//    public static <T> byte[] writeObject(T obj) {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        Output output = new Output(byteArrayOutputStream);
//        KryoPool pool = getPool();
//        Kryo kryo = pool.borrow();
//        kryo.writeObject(output, obj);
//        output.flush();
//        pool.release(kryo);
//        return byteArrayOutputStream.toByteArray();
//    }

    /**
     * 将对象序列化为 String
     * 利用了 Base64 编码
     * @param obj 任意对象
     * @param <T> 对象的类型
     * @return 序列化后的字符串
     */
//    public static <T> String writeObjectToString(T obj) {
//        try {
//            return new String(Base64.encodeBase64(writeObject(obj)), DEFAULT_ENCODING);
//        } catch (UnsupportedEncodingException e) {
//            throw new IllegalStateException(e);
//        }
//    }

    /**
     * 将字节数组反序列化为原对象
     * @param byteArray writeToByteArray 方法序列化后的字节数组
     * @param clazz     原对象的 Class
     * @param <T>       原对象的类型
     * @return 原对象
     */
//    @SuppressWarnings("unchecked")
//    public static <T> T readObjectFromByteArray(byte[] byteArray, Class<T> clazz) {
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
//        Input input = new Input(byteArrayInputStream);
//        KryoPool pool = getPool();
//        Kryo kryo = pool.borrow();
//        T res = (T)kryo.readObject(input, clazz);
//        pool.release(kryo);
//        return res;
//    }

    /**
     * 将 String 反序列化为原对象，利用了 Base64 编码
     * @param str   writeToString 方法序列化后的字符串
     * @param clazz 原对象的 Class
     * @param <T>   原对象的类型
     * @return 原对象，当参数为 null 时，返回 null
     */
//    public static <T> T readObjectFromString(String str, Class<T> clazz) {
//        if (StringUtils.isEmpty(str)) {
//            return null;
//        }
//        try {
//            return readObjectFromByteArray(Base64.decodeBase64(str.getBytes(DEFAULT_ENCODING)), clazz);
//        } catch (UnsupportedEncodingException e) {
//            throw new IllegalStateException(e);
//        }
//    }
}
