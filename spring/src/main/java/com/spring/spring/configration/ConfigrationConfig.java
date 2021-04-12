package com.spring.spring.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigrationConfig {

    //aa.test
//    @Bean
//    public User user(){
//        return new User();
//    }

    //test2
    @Bean
    public User user(){
        return new User();
    }

    @Bean
    public UserService userService(){
        return new UserService(user());
    }
}
