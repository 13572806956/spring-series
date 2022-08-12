package com.me.springseries.lesson002.demo18.test3;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@MyScope
public class User {

    private String username;

    public User() {
        System.out.println("---------创建User对象" + this); //@2
        this.username = UUID.randomUUID().toString(); //@3
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
