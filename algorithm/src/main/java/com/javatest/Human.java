package com.javatest;

import lombok.Data;

@Data
public class Human {
    private String name;
    private Integer age;
    private Integer height;

    public Human() {
    }

    public Human(String name, Integer age, Integer height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
