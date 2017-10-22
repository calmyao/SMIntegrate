package com.yao.mapper;

import com.yao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Calm on 2017/10/22
 */
@Mapper
public interface UserMapper {

    @Select(value = "select * from user where username like '%${value}%'")
    public List<User> getByUserName(String username);

}
