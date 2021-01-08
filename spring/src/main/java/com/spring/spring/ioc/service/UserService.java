package com.spring.spring.ioc.service;

import com.spring.spring.ioc.bean.User;

public class UserService {

    private User user;

    public UserService() {
        System.out.println("UserService()");
    }

    public UserService(User user) {
        System.out.println("UserService(User user)");
    }
}
