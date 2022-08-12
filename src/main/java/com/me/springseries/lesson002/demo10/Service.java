package com.me.springseries.lesson002.demo10;

import org.springframework.beans.factory.InitializingBean;

public class Service implements InitializingBean {

    public void init(){
        System.out.println("调用init()方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用afterPropertiesSet()方法");
    }
}
