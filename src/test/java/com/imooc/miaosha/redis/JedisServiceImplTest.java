package com.imooc.miaosha.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Richard_yyf
 * @Date 2018/11/21
 * @Description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisServiceImplTest {

    @Autowired
    private JedisService jedisService;

    @Test
    public void testJedisGet() {
        String value = jedisService.get("key1");
        System.out.println(value);
        assertEquals("123456", value);
    }

}