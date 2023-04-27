package com.me.demo3;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventTest {

    @Test
    public void test0() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig0.class);
        //获取用户注册服务
        UserRegisterService userRegisterService = context.getBean(UserRegisterService.class);
        //模拟用户注册
        userRegisterService.registerUser("路人甲Java");
    }
}
