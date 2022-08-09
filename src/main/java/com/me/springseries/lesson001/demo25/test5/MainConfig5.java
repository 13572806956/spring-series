package com.me.springseries.lesson001.demo25.test5;

import org.springframework.context.annotation.Import;

@Import({Condition2.class, Condition3.class, Condition1.class})
public class MainConfig5 {
}
