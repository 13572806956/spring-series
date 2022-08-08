package com.me.springseries.demo24.test7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ME
 * @create 2022-08-09 0:08
 */
@Configuration
public class Configuration3 {
    @Bean
    public String name3() {
        System.out.println("name3");
        return "name3";
    }
}
