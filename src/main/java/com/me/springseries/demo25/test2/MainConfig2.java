package com.me.springseries.demo25.test2;

import org.springframework.context.annotation.Import;

@Import({DevBeanConfig.class, ProdBeanConfig.class, TestBeanConfig.class})
public class MainConfig2 {
}
