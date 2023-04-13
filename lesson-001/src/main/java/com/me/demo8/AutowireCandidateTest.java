package com.me.demo8;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean元素的autowire-candidate可以设置当前bean是否作为其他bean自动注入的候选bean
 */
public class AutowireCandidateTest {

    @Test
    public void setterBean() {
        String beanXml = "classpath:setterBean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println(context.getBean(SetterBean.class)); //@1
        SetterBean.IService service = context.getBean(SetterBean.IService.class); //@2
        System.out.println(service);
    }
}
