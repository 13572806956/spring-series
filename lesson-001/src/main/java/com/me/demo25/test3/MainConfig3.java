package com.me.demo25.test3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@Conditional(MyCondition1.class)
public class MainConfig3 {
    @Bean
    public String name() { //@1
        return "路人甲Java";
    }
}
