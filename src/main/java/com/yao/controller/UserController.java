package com.yao.controller;

import com.yao.pojo.User;
import com.yao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Calm on 2017/10/22
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/springboot/mybatis/{username}")
    @ResponseBody
    public List<User> getUserByUsername(@PathVariable String username) {
        List<User> list = userService.getUserByUserName(username);
        return list;
    }

    @RequestMapping("/springBoot/mybatis/page/info")
    @ResponseBody
    public List<User> getUserByPage() {
        Integer page =1;
        Integer rows = 3;
        List<User> list = userService.getUserByPage(page, rows);
        return list;

    }



}
