package com.me.demo25.test1;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BeanConfig1.class,BeanConfig2.class}) //@1
public class MainConfig1 {
}
