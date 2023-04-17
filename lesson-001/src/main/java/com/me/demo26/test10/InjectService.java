package com.me.demo26.test10;

import com.me.demo26.test9.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("injectService1")
public class InjectService {

    private IService s1;

    private IService s2;

    @Autowired
    public void injectBean(@Qualifier("service2") IService s1, @Qualifier("service1") IService s2) { //@1
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public String toString() {
        return "InjectService{" +
                "s1=" + s1 +
                ", s2=" + s2 +
                '}';
    }

}
