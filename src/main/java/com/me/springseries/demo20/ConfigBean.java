package com.me.springseries.demo20;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {

    @Bean
    public User user1(){
        return new User();
    }

    @Bean("user2Bean")
    public User user2(){
        return new User();
    }

    @Bean({"user3Bean", "user3BeanAlias1", "user3BeanAlias2"})
    public User user3(){
        return new User();
    }
}
