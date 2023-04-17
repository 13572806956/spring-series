package com.me.demo25.test7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Conditional(MyConfigurationCondition1.class)
@Configuration
public class BeanConfig2 {
    @Bean
    public String name() {
        return "路人甲Java";
    }
}
