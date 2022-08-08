package com.me.springseries.demo22.test5;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages = {"com.me.springseries.demo22.test4"},
               useDefaultFilters = false,   // 不使用默认过滤器
               includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyFilter.class)})
public class ScanBean5 {
}
