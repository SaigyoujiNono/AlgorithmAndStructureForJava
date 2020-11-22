package com.structure.linkedlist2;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private String name;
    private Integer age;
    private Integer high;

    public User(String name, Integer age, Integer high) {
        this.name = name;
        this.age = age;
        this.high = high;
    }
}
