package com.me.springseries.demo24.test5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ME
 * @create 2022-08-08 23:48
 */
@Configuration
public class Module1Config {

    @Bean
    public String name() {
        return "公众号:路人甲";
    }

    @Bean
    public String address() {
        return "上海";
    }
}
