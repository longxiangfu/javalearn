package com.spring.spring.ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Fish {

//    public Fish(Monkey monkey){}


    @Autowired
    private Monkey monkey;
    public Fish(){}
}
