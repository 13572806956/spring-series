package com.me.springseries.demo24.test8;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ME
 * @create 2022-08-09 0:12
 */
@Configuration
public class Configuration1 {
    @Bean
    public String name1() {
        System.out.println("name1");
        return "name1";
    }
}
