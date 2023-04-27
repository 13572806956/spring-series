package com.me.demo6;

import com.me.demo5.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterListener {

    @EventListener
    public void sendMail(UserRegisterEvent event) {
        System.out.println(String.format("【%s】，给用户【%s】发送注册成功邮件!", Thread.currentThread(), event.getUserName()));
    }

    @EventListener
    public void sendCompon(UserRegisterEvent event) {
        System.out.println(String.format("【%s】，给用户【%s】发送优惠券!", Thread.currentThread(), event.getUserName()));
    }
}
