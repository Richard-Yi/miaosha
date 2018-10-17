package com.imooc.miaosha.service;

import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * @author Richard_yyf
 * @Date 2018/10/16
 * @Description
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * find by id
     * @param id
     * @return
     */
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean tx(String s) {
        User user1 = new User("1", "Ric");
        User user2 = new User("2", "Ric2");
        userDao.insert(user2);
        // 测试事务， user1 插入时会报错，看看user1是否插入成功，如果没有插入，则事务生效
        userDao.insert(user1);
        return true;
    }
}
