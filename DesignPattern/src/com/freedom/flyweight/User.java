package com.freedom.flyweight;

/**
 * 享元模式的外部状态
 *
 * @author liuf
 * date: 2020-02-07
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
