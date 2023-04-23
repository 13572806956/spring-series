package com.me.demo18;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@Configurable
@ComponentScan
@PropertySource({"classpath:db.properties"})
public class MainConfig1 {
}
