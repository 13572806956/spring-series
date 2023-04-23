package com.me.demo3.test3;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @title: UserModel
 * @author: GXW
 * @date: 2023/4/24 0:04
 */
public class UserModel {

    @Autowired
    private String name; //@1

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
