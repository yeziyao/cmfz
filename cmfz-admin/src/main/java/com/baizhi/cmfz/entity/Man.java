package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class Man implements Serializable{
    private String name;
    private Integer value;

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public Man() {
    }

    public Man(String name, Integer value) {

        this.name = name;
        this.value = value;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
