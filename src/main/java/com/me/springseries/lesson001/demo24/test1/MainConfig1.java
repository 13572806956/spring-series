package com.me.springseries.lesson001.demo24.test1;

import org.springframework.context.annotation.Import;

/**
 * @author ME
 * @create 2022-08-08 21:18
 */
@Import({Service1.class, Service2.class})
public class MainConfig1 {
}
