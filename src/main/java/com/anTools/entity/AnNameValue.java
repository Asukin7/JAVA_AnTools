package com.anTools.entity;

import java.io.Serializable;

public class AnNameValue implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Float value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AnNameValue{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

}
