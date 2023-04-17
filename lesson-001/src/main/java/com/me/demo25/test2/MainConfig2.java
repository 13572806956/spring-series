package com.me.demo25.test2;

import org.springframework.context.annotation.Import;

@Import({DevBeanConfig.class, TestBeanConfig.class, ProdBeanConfig.class})
public class MainConfig2 {
}
