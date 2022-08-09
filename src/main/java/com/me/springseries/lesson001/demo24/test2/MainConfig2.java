package com.me.springseries.lesson001.demo24.test2;

import org.springframework.context.annotation.Import;

/**
 * @author ME
 * @create 2022-08-08 21:25
 */
@Import({ConfigModule1.class, ConfigModule2.class})
public class MainConfig2 {
}
