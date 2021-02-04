package com.spring.spring.ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Monkey {

//    public Monkey(Fish fish){}

    @Autowired
    private Fish fish;
    public Monkey(){}
}
