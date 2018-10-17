package com.imooc.miaosha.domain;

/**
 * @author Richard_yyf
 * @Date 2018/10/16
 * @Description
 */
public class User {

    private String id;

    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
