package com.imooc.miaosha.dao;

import com.imooc.miaosha.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 接口形式 不需要写xml文件
 *
 * @author Richard_yyf
 * @Date 2018/10/16
 * @Description
 */

@Mapper
public interface UserDao {

    /**
     * find by id
     * @param id
     * @return
     */
    @Select("SELECT * FROM User WHERE id = #{id}")
    User findById(@Param("id") String id);

    /**
     * insert user
     * @param user
     * @return
     */
    @Insert("INSERT INTO User(id, name) VALUES (#{id},#{name})")
    int insert(User user);
}
