package com.yao.service;

import com.yao.pojo.User;

import java.util.List;

/**
 * Created by Calm on 2017/10/22
 */
public interface UserService {
    public List<User> getUserByUserName(String username);

    public List<User> getUserByPage(Integer page,Integer rows);
}
