package com.spring.spring.mybatisSpring.dao;

import com.spring.spring.mybatisSpring.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> query();
}
