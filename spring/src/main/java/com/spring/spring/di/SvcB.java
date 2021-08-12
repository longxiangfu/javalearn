package com.spring.spring.di;

import org.springframework.stereotype.Service;

@Service
public class SvcB implements Svc {
    @Override
    public void sayHello() {
        System.out.println("hello,this is service B");
    }
}
