package com.me.demo4;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

public class ThreadScopeTest {
    public static void main(String[] args) throws InterruptedException {
        String beanXml = "classpath:beans-thread.xml";
        //手动创建容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext() {
            @Override
            protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
                // 向容器中注册自定义的scope
                beanFactory.registerScope(ThreadScope.THREAD_SCOPE, new ThreadScope());
                super.postProcessBeanFactory(beanFactory);
            }
        };
        //设置配置文件位置
        context.setConfigLocation(beanXml);
        //启动容器
        context.refresh();
        //使用容器获取bean
        for (int i = 0; i < 2; i++) {//@2
            new Thread(() -> {
                System.out.println(Thread.currentThread() + "," + context.getBean("threadBean"));
                System.out.println(Thread.currentThread() + "," + context.getBean("threadBean"));
            }).start();
            TimeUnit.SECONDS.sleep(1);
        }

    }
}
