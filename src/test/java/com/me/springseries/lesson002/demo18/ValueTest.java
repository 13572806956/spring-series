package com.me.springseries.lesson002.demo18;

import com.me.springseries.lesson002.demo18.test1.DbConfig;
import com.me.springseries.lesson002.demo18.test1.MainConfig1;
import com.me.springseries.lesson002.demo18.test2.DbUtil;
import com.me.springseries.lesson002.demo18.test2.MainConfig;
import com.me.springseries.lesson002.demo18.test2.MainConfig2;
import com.me.springseries.lesson002.demo18.test3.BeanMyScope;
import com.me.springseries.lesson002.demo18.test3.MainConfig3;
import com.me.springseries.lesson002.demo18.test3.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

public class ValueTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();

        DbConfig dbConfig = context.getBean(DbConfig.class);
        System.out.println(dbConfig);
    }

    @Test
    public void test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        Map<String, Object> mailInfoFromDb = DbUtil.getMailInfoFromDb();

        MapPropertySource mapPropertySource = new MapPropertySource("mail", mailInfoFromDb);
        context.getEnvironment().getPropertySources().addFirst(mapPropertySource);

        context.register(MainConfig2.class);
        context.refresh();
        MainConfig mainConfig = context.getBean(MainConfig.class);
        System.out.println(mainConfig);
    }

    @Test
    public void test3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getBeanFactory().registerScope(BeanMyScope.SCOPE_MY, new BeanMyScope());
        context.register(MainConfig3.class);
        context.refresh();

        System.out.println("从容器中获取user对象");
        User user = context.getBean(User.class);
        System.out.println("user对象的class为：" + user.getClass()); //@3

        System.out.println("多次调用user的getUsername感受一下效果\n");
        for (int i = 1; i <= 3; i++) {
            System.out.println(String.format("********\n第%d次开始调用getUsername", i));
            System.out.println(user.getUsername());
            System.out.println(String.format("第%d次调用getUsername结束\n********\n", i));
        }
    }
}
