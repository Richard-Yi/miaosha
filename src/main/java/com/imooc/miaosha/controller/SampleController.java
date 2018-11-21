package com.imooc.miaosha.controller;

import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.redis.JedisService;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * demo controller
 *
 * @author Richard_yyf
 * @version 1.0 2018/10/15
 */
@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    private UserService userService;

    @Autowired
    private JedisService jedisService;

    /**
     * 测试 db
     * @return
     */
    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> doGet() {
        User user = userService.findById("1");
        return Result.success(user);
    }

    /**
     * 测试事务
     * @return
     */
    @RequestMapping("/db/gtx")
    @ResponseBody
    public Result<Boolean> tx() {
        userService.tx("1");
        return Result.success(true);
    }

    /**
     * 测试redis
     *
     * @return
     */
    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<Boolean> redisGet() {

        return Result.success(true);
    }
}
