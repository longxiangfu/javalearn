package com.springboot.test;

import com.springboot.app.SpringApplication;
import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

/**
 * 测试spring零配置原理
 */
public class TestZeroConfig {

    public static void main(String[] args) throws LifecycleException, ServletException {
        SpringApplication.run();
    }
}
