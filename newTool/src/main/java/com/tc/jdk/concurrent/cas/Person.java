package com.tc.jdk.concurrent.cas;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Cloneable, Serializable {
    private static final long serialVersionUID = 9003018169432235531L;
    private Integer id;
    private String name;
    public Integer age;
    public int no;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

}
