package com.tc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.tc")
public class ShardingJdbcApplication {
    public static void main( String[] args ) {
        SpringApplication.run(ShardingJdbcApplication.class, args);
    }
}
