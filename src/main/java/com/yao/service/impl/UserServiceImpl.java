package com.yao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yao.mapper.UserGeneralMapper;
import com.yao.mapper.UserMapper;
import com.yao.pojo.User;
import com.yao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Calm on 2017/10/22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserGeneralMapper userGeneralMapper;


    @Override
    public List<User> getUserByUserName(String username) {
        List<User> list = userMapper.getByUserName(username);
        return list;
    }

    @Override
    public List<User> getUserByPage(Integer page, Integer rows) {
        //1.设置分页条件
        PageHelper.startPage(page,rows);
        //2.紧跟着的第一个查询,才会被分页
        //3.执行查询 得到得到结果 结果就是被分页过的
        List<User> list = userGeneralMapper.select(null);
        System.out.println("数量" + list.size());
        //页面需要用到总记录数,列数
        //设置分页对象
        PageInfo<User> info = new PageInfo<User>(list);
        System.out.println("总记录数:"+info.getTotal());
        return list;
    }

}
