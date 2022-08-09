package com.me.springseries.lesson001.demo25.test7;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig1 {
    //@Bean
    public Service service(){
        return new Service();
    }
}
