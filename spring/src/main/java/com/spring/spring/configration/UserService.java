package com.spring.spring.configration;

public class UserService {

    public UserService() {
        System.out.println("UserService无参构造");
    }


    public UserService(User user) {
            System.out.println("UserService有参构造--user:" + user);
    }


}
