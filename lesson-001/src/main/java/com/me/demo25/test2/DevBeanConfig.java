package com.me.demo25.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnvConditional(EnvConditional.Env.DEV) //@1
public class DevBeanConfig {
    @Bean
    public String name() {
        return "我是开发环境!";
    }
}
