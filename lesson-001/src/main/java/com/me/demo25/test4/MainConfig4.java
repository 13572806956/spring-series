package com.me.demo25.test4;

import com.me.demo25.test3.MyCondition1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig4 {
    @Conditional(MyCondition1.class)
    @Bean
    public String name() {
        return "路人甲Java";
    }
    @Bean
    public String address() {
        return "上海市";
    }
}
