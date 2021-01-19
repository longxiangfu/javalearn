package com.spring.spring.mybatisSpring.dao;

import com.spring.spring.mybatisSpring.bean.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper {

    @Select("select * from account")
    List<Account> query();
}
