package com.nwu.quantum.service;

import com.nwu.quantum.entity.User;


public interface UserService {
    /**
     * 用户登录
     * @param email 邮箱
     * @param password 密码
     * @return User 用户信息
     */
    public User login(String email,String password);

    /**
     * 用户注册
     * @param email 邮箱
     * @param password 密码
     */
    public  int  register(String email,String password);
}

