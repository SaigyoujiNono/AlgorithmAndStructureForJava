package com.structure.hashcode;

import lombok.Data;

/**
 * 表示雇员employ
 */
@Data
public class Emp {
    private int id;
    private String name;
    private Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setNext(Emp next) {
        this.next = next;
    }
}
