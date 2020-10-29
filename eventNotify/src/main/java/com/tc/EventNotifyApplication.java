package com.tc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.tc")
public class EventNotifyApplication {
    public static void main( String[] args ) {
        SpringApplication.run(EventNotifyApplication.class, args);
    }
}
