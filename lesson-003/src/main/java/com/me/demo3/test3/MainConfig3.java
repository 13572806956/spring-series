package com.me.demo3.test3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @title: MainConfig3
 * @author: GXW
 * @date: 2023/4/24 0:05
 */
@Configuration
@ComponentScan
public class MainConfig3 {

    @Bean
    public UserModel user1() {
        return new UserModel();
    }

    @Bean
    public UserModel user2() {
        return new UserModel();
    }

    @Bean
    public String name() {
        return "路人甲Java,带大家成功java高手!";
    }
}
