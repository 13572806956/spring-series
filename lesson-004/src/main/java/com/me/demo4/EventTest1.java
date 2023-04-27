package com.me.demo4;

import org.junit.Test;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

public class EventTest1 {

    @Test
    public void test2() {
        //创建事件广播器
        ApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster();
        //注册事件监听器
        applicationEventMulticaster.addApplicationListener(new SendEmailOnOrderCreateListener());
        //广播事件订单创建事件
        applicationEventMulticaster.multicastEvent(new OrderCreateEvent(applicationEventMulticaster, 1L));
    }
}
