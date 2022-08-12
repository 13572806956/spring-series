package com.me.springseries.lesson002.demo17.model1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service2 {

    @Autowired
    private Service1 service1;

    public String m1(){
        return this.service1.m1();
    }
}
