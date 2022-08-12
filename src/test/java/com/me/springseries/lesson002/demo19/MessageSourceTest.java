package com.me.springseries.lesson002.demo19;

import com.me.springseries.lesson002.demo19.demo1.MainConfig1;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class MessageSourceTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();

        context.getMessage("name", null, null);
        context.getMessage("name", null, Locale.CHINA);
        context.getMessage("name", null, Locale.UK);
    }
}
