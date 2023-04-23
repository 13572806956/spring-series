package com.me.demo17.module1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service2 {

    @Autowired
    private Service1 service1; //@1

    public String m1() { //@2
        return this.service1.m1();
    }
}
