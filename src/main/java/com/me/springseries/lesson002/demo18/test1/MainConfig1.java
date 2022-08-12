package com.me.springseries.lesson002.demo18.test1;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@Configurable
@ComponentScan
@PropertySource("classpath:com.me.springseries.lesson002.demo18/db.properties")
public class MainConfig1 {
}
