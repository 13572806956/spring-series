package com.me.demo26.test13;

import org.springframework.beans.factory.annotation.Autowired;

public class InjectService {

    @Autowired
    private IService service1;//@1

    @Override
    public String toString() {
        return "InjectService{" +
                "service1=" + service1 +
                '}';
    }
}
