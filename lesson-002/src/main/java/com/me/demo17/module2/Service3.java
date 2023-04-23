package com.me.demo17.module2;

import com.me.demo17.module1.Service2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service3 {

    @Autowired
    private Service1 service1; //@1

    @Autowired
    private Service2 service2; //@2

    public String m1() { //@2
        return this.service2.m1();
    }

    public String m2() { //@2
        return this.service1.m2();
    }
}
