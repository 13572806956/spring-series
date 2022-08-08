package com.me.springseries.demo24.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ME
 * @create 2022-08-08 21:23
 */
@Configuration
public class ConfigModule2 {
    @Bean
    public String module2() {
        return "我是模块2的配置类";
    }
}
