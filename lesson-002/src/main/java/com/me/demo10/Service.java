package com.me.demo10;

import org.springframework.beans.factory.InitializingBean;

public class Service implements InitializingBean {

    public void init() {
        System.out.println("调用init()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用afterPropertiesSet()");
    }
}
