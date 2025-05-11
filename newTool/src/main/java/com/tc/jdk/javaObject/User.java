package com.tc.jdk.javaObject;

import lombok.Data;

import java.util.Objects;

@Data
public class User {
    private Long id;
    private String name;

    public User(){}

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
