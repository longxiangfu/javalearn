package com.tc.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.tc")
public class commonApplication {
    public static void main( String[] args ) {
        SpringApplication.run(commonApplication.class, args);
    }
}
