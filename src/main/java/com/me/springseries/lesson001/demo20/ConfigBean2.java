package com.me.springseries.lesson001.demo20;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean2 {

    @Bean
    public ServiceA serviceA(){
        System.out.println("调用serviceA()方法");
        return new ServiceA();
    }

    @Bean
    public ServiceB serviceB1(){
        System.out.println("调用serviceB()方法");
        ServiceA serviceA = this.serviceA();
        return new ServiceB(serviceA);
    }

    @Bean
    public ServiceB serviceB2(){
        System.out.println("调用serviceB2()方法");
        ServiceA serviceA = this.serviceA();
        return new ServiceB(serviceA);
    }
}
