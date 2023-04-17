package com.me.demo26.test7;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Service2 {

    @Resource
    private IService service0;//@1

    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service0 +
                '}';
    }
}
