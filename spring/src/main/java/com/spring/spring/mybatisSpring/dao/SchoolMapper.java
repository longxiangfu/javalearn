package com.spring.spring.mybatisSpring.dao;

import com.spring.spring.mybatisSpring.bean.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SchoolMapper {

    @Select("select * from school")
    List<Account> query();
}
