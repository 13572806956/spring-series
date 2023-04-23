package com.me;

import com.me.demo1.*;
import com.me.demo10.Service;
import com.me.demo12.MySmartInitializingSingleton;
import com.me.demo17.module1.Module1Config;
import com.me.demo17.module2.Module2Config;
import com.me.demo17.module2.Service3;
import com.me.demo18.*;
import com.me.demo18.test3.BeanMyScope;
import com.me.demo18.test3.MainConfig3;
import com.me.demo18.test4.BeanRefreshScope;
import com.me.demo18.test4.MailService;
import com.me.demo18.test4.MainConfig4;
import com.me.demo18.test4.RefreshConfigUtil;
import com.me.demo6.MySmartInstantiationAwareBeanPostProcessor;
import com.me.demo6.Person;
import com.me.demo7.UserModel;
import com.me.demo8.AwareBean;
import com.me.demo9.Bean1;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MapPropertySource;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestMain {

    @Test
    public void test1() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Car.class.getName());
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(beanDefinition);
    }

    @Test
    public void test2() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Car.class.getName());
        beanDefinitionBuilder.addPropertyValue("name", "奥迪");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("car", beanDefinition);
        Car car = factory.getBean("car", Car.class);
        System.out.println(car);
    }

    @Test
    public void test3() {
        BeanDefinition carBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Car.class.getName()).addPropertyValue("name", "奥迪").getBeanDefinition();
        BeanDefinition userBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(User.class.getName())
                .addPropertyValue("name", "路人甲")
                .addPropertyReference("car", "car")
                .getBeanDefinition();
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("user", userBeanDefinition);
        factory.registerBeanDefinition("car", carBeanDefinition);
        System.out.println(factory.getBean("car"));
        System.out.println(factory.getBean("user"));
    }

    @Test
    public void test4() {
        BeanDefinition carBeanDefinition1 = BeanDefinitionBuilder.genericBeanDefinition(Car.class)
                .addPropertyValue("name", "保时捷")
                .getBeanDefinition();
        BeanDefinition carBeanDefinition2 = BeanDefinitionBuilder.genericBeanDefinition()
                .setParentName("car1")
                .getBeanDefinition();
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("car1", carBeanDefinition1);
        factory.registerBeanDefinition("car2", carBeanDefinition2);
        //从容器中获取car1
        System.out.println(String.format("car1->%s", factory.getBean("car1")));
        //从容器中获取car2
        System.out.println(String.format("car2->%s", factory.getBean("car2")));
    }

    @Test
    public void test5() {
        BeanDefinition car1 = BeanDefinitionBuilder.genericBeanDefinition(Car.class)
                .addPropertyValue("name", "奥迪")
                .getBeanDefinition();
        BeanDefinition car2 = BeanDefinitionBuilder.genericBeanDefinition(Car.class)
                .addPropertyValue("name", "保时捷")
                .getBeanDefinition();

        ManagedList<String> stringList = new ManagedList<>();
        stringList.addAll(Arrays.asList("java高并发系列", "mysql系列", "maven高手系列"));

        //创建carList这个属性对应的值,内部引用其他两个bean的名称[car1,car2]
        ManagedList<RuntimeBeanReference> carList = new ManagedList<>();
        carList.add(new RuntimeBeanReference("car1"));
        carList.add(new RuntimeBeanReference("car2"));

        //创建stringList这个属性对应的值
        ManagedSet<String> stringSet = new ManagedSet<>();
        stringSet.addAll(Arrays.asList("java高并发系列", "mysql系列", "maven高手系列"));

        //创建carSet这个属性对应的值,内部引用其他两个bean的名称[car1,car2]
        ManagedList<RuntimeBeanReference> carSet = new ManagedList<>();
        carSet.add(new RuntimeBeanReference("car1"));
        carSet.add(new RuntimeBeanReference("car2"));

        //创建stringMap这个属性对应的值
        ManagedMap<String, String> stringMap = new ManagedMap<>();
        stringMap.put("系列1", "java高并发系列");
        stringMap.put("系列2", "Maven高手系列");
        stringMap.put("系列3", "mysql系列");

        ManagedMap<String, RuntimeBeanReference> stringCarMap = new ManagedMap<>();
        stringCarMap.put("car1", new RuntimeBeanReference("car1"));
        stringCarMap.put("car2", new RuntimeBeanReference("car2"));

        GenericBeanDefinition compositeObj = new GenericBeanDefinition();
        compositeObj.setBeanClassName(CompositeObj.class.getName());
        compositeObj.getPropertyValues().add("name", "路人甲Java").
                add("salary", 50000).
                add("car1", new RuntimeBeanReference("car1")).
                add("stringList", stringList).
                add("carList", carList).
                add("stringSet", stringSet).
                add("carSet", carSet).
                add("stringMap", stringMap).
                add("stringCarMap", stringCarMap);

        //将上面bean 注册到容器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("car1", car1);
        factory.registerBeanDefinition("car2", car2);
        factory.registerBeanDefinition("compositeObj", compositeObj);
        //下面我们将容器中所有的bean输出
        for (String beanName : factory.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, factory.getBean(beanName)));
        }
    }

    @Test
    public void test6() {
        //定义一个spring容器，这个容器默认实现了BeanDefinitionRegistry，所以本身就是一个bean注册器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //定义一个xml的BeanDefinition读取器，需要传递一个BeanDefinitionRegistry（bean注册器）对象
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);

        //指定bean1.xml配置文件的位置
        String location = "classpath:bean1.xml";
        int countBean = xmlBeanDefinitionReader.loadBeanDefinitions(location);
        System.out.println(String.format("共注册了 %s 个bean", countBean));

        //打印出注册的bean的配置信息
        for (String beanName : factory.getBeanDefinitionNames()) {
            //通过名称从容器中获取对应的BeanDefinition信息
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
            //获取BeanDefinition具体使用的是哪个类
            String beanDefinitionClassName = beanDefinition.getClass().getName();
            //通过名称获取bean对象
            Object bean = factory.getBean(beanName);
            //打印输出
            System.out.println(beanName + ":");
            System.out.println("    beanDefinitionClassName：" + beanDefinitionClassName);
            System.out.println("    beanDefinition：" + beanDefinition);
            System.out.println("    bean：" + bean);
        }
    }

    @Test
    public void test7() {

        //定义一个spring容器，这个容器默认实现了BeanDefinitionRegistry，所以本身就是一个bean注册器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //定义一个注解方式的BeanDefinition读取器，需要传递一个BeanDefinitionRegistry（bean注册器）对象
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(factory);

        annotatedBeanDefinitionReader.register(Service1.class, Service2.class);

        factory.getBeansOfType(BeanPostProcessor.class).values().forEach(factory::addBeanPostProcessor);

        //打印出注册的bean的配置信息
        for (String beanName : new String[]{"service1", "service2"}) {
            //通过名称从容器中获取对应的BeanDefinition信息
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
            //获取BeanDefinition具体使用的是哪个类
            String beanDefinitionClassName = beanDefinition.getClass().getName();
            //通过名称获取bean对象
            Object bean = factory.getBean(beanName);
            //打印输出
            System.out.println(beanName + ":");
            System.out.println("    beanDefinitionClassName：" + beanDefinitionClassName);
            System.out.println("    beanDefinition：" + beanDefinition);
            System.out.println("    bean：" + bean);
        }
    }

    @Test
    public void test8() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //创建一个SmartInstantiationAwareBeanPostProcessor,将其添加到容器中
        factory.addBeanPostProcessor(new MySmartInstantiationAwareBeanPostProcessor());
        factory.registerBeanDefinition("name",
                BeanDefinitionBuilder.genericBeanDefinition(String.class)
                        .addConstructorArgValue("路人甲Java")
                        .getBeanDefinition());
        factory.registerBeanDefinition("age",
                BeanDefinitionBuilder.genericBeanDefinition(Integer.class)
                        .addConstructorArgValue(30)
                        .getBeanDefinition());
        factory.registerBeanDefinition("person",
                BeanDefinitionBuilder.genericBeanDefinition(Person.class).getBeanDefinition());
        Person person = factory.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void test9() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
                if ("user1".equals(beanName)) {
                    return false;
                }
                return true;
            }
        });
        factory.registerBeanDefinition("user1", BeanDefinitionBuilder.
                genericBeanDefinition(UserModel.class).
                addPropertyValue("name", "路人甲Java").
                addPropertyValue("age", 30).
                getBeanDefinition());
        factory.registerBeanDefinition("user2", BeanDefinitionBuilder.
                genericBeanDefinition(UserModel.class).
                addPropertyValue("name", "刘德华").
                addPropertyValue("age", 50).
                getBeanDefinition());
        for (String beanName : factory.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, factory.getBean(beanName)));
        }
    }

    @Test
    public void test10() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
                if ("user1".equals(beanName)) {
                    if (pvs == null) {
                        pvs = new MutablePropertyValues();
                    }
                    if (pvs instanceof MutablePropertyValues) {
                        MutablePropertyValues mpvs = (MutablePropertyValues) pvs;
                        //将姓名设置为：路人
                        mpvs.add("name", "路人");
                        //将年龄属性的值修改为18
                        mpvs.add("age", 18);
                    }
                }
                return null;
            }
        });
        factory.registerBeanDefinition("user1", BeanDefinitionBuilder.
                genericBeanDefinition(UserModel.class).
                getBeanDefinition()); //@1
        factory.registerBeanDefinition("user2", BeanDefinitionBuilder.
                genericBeanDefinition(UserModel.class).
                addPropertyValue("name", "刘德华").
                addPropertyValue("age", 50).
                getBeanDefinition());
        for (String beanName : factory.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, factory.getBean(beanName)));
        }
    }

    @Test
    public void test11() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("awareBean", BeanDefinitionBuilder.genericBeanDefinition(AwareBean.class).getBeanDefinition());
        //调用getBean方法获取bean，将触发bean的初始化
        factory.getBean("awareBean");
    }

    @Test
    public void test12() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Bean1.class);
        context.refresh();
    }

    @Test
    public void test13() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Service.class).setInitMethodName("init").getBeanDefinition();
        factory.registerBeanDefinition("service", beanDefinition);
        System.out.println(factory.getBean("service"));
    }

    @Test
    public void test14() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("postProcessAfterInitialization：" + beanName);
                return bean;
            }
        });

        //下面注册2个String类型的bean
        factory.registerBeanDefinition("name",
                BeanDefinitionBuilder.
                        genericBeanDefinition(String.class).
                        addConstructorArgValue("公众号：【路人甲Java】").
                        getBeanDefinition());
        factory.registerBeanDefinition("personInformation",
                BeanDefinitionBuilder.genericBeanDefinition(String.class).
                        addConstructorArgValue("带领大家成为java高手！").
                        getBeanDefinition());
        System.out.println("-------输出bean信息---------");
        for (String beanName : factory.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, factory.getBean(beanName)));
        }
    }

    @Test
    public void test15() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MySmartInitializingSingleton.class);
        System.out.println("开始启动容器!");
        context.refresh();
        System.out.println("容器启动完毕!");
    }

    @Test
    public void test16() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("service1", BeanDefinitionBuilder.genericBeanDefinition(Service1.class).getBeanDefinition());
        factory.registerBeanDefinition("service2", BeanDefinitionBuilder.genericBeanDefinition(Service2.class).getBeanDefinition());
        factory.registerBeanDefinition("mySmartInitializingSingleton", BeanDefinitionBuilder.genericBeanDefinition(MySmartInitializingSingleton.class).getBeanDefinition());
        System.out.println("准备触发所有单例bean初始化");
        //触发所有bean初始化，并且回调 SmartInitializingSingleton#afterSingletonsInstantiated 方法
        factory.preInstantiateSingletons();
    }

    @Test
    public void test20() {
        //定义容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册bean
        context.register(Module1Config.class, Module2Config.class); //@1
        //启动容器
        context.refresh();
    }

    @Test
    public void test21() {
        //创建父容器
        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
        //向父容器中注册Module1Config配置类
        parentContext.register(Module1Config.class);
        //启动父容器
        parentContext.refresh();

        //创建子容器
        AnnotationConfigApplicationContext childContext = new AnnotationConfigApplicationContext();
        //向子容器中注册Module2Config配置类
        childContext.register(Module2Config.class);
        //给子容器设置父容器
        childContext.setParent(parentContext);
        //启动子容器
        childContext.refresh();

        //从子容器中获取Service3
        Service3 service3 = childContext.getBean(Service3.class);
        System.out.println(service3.m1());
        System.out.println(service3.m2());
    }

    @Test
    public void test22() {
        //创建父容器parentFactory
        DefaultListableBeanFactory parentFactory = new DefaultListableBeanFactory();
        //向父容器parentFactory注册一个bean[userName->"路人甲Java"]
        parentFactory.registerBeanDefinition("userName",
                BeanDefinitionBuilder.
                        genericBeanDefinition(String.class).
                        addConstructorArgValue("路人甲Java").
                        getBeanDefinition());
        //创建一个子容器childFactory
        DefaultListableBeanFactory childFactory = new DefaultListableBeanFactory();
        //调用setParentBeanFactory指定父容器
        childFactory.setParentBeanFactory(parentFactory);
        //向子容器parentFactory注册一个bean[address->"上海"]
        childFactory.registerBeanDefinition("address",
                BeanDefinitionBuilder.
                        genericBeanDefinition(String.class).
                        addConstructorArgValue("上海").
                        getBeanDefinition());
        System.out.println("获取bean【userName】：" + childFactory.getBean("userName"));//@1
        System.out.println(Arrays.asList(childFactory.getBeanNamesForType(String.class))); //@2

        String[] beanNamesForTypeIncludingAncestors = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(childFactory, String.class);
        System.out.println(Arrays.asList(beanNamesForTypeIncludingAncestors));
        Map<String, String> beansOfTypeIncludingAncestors  = BeanFactoryUtils.beansOfTypeIncludingAncestors(childFactory, String.class);
        System.out.println(Arrays.asList(beansOfTypeIncludingAncestors ));

    }

    @Test
    public void test23() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();
        DbConfig dbConfig = context.getBean(DbConfig.class);
        System.out.println(dbConfig);
    }

    @Test
    public void test24() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        /*下面这段是关键 start*/
        //模拟从db中获取配置信息
        Map<String, Object> mailInfoFromDb = DbUtil.getMailInfoFromDb();
        //将其丢在MapPropertySource中（MapPropertySource类是spring提供的一个类，是PropertySource的子类）
        MapPropertySource mailPropertySource = new MapPropertySource("mail", mailInfoFromDb);
        //将mailPropertySource丢在Environment中的PropertySource列表的第一个中，让优先级最高
        context.getEnvironment().getPropertySources().addFirst(mailPropertySource);
        /*上面这段是关键 end*/
        context.register(MainConfig2.class);
        context.refresh();
        MailConfig mailConfig = context.getBean(MailConfig.class);
        System.out.println(mailConfig);
    }

    @Test
    public void test25() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //将自定义作用域注册到spring容器中
        context.getBeanFactory().registerScope(BeanMyScope.SCOPE_MY, new BeanMyScope());//@1
        context.register(MainConfig3.class);
        context.refresh();
        System.out.println("从容器中获取User对象");
        com.me.demo18.test3.User user = context.getBean(com.me.demo18.test3.User.class); //@2
        System.out.println("user对象的class为：" + user.getClass()); //@3
        System.out.println("多次调用user的getUsername感受一下效果\n");
        for (int i = 1; i <= 3; i++) {
            System.out.println(String.format("********\n第%d次开始调用getUsername", i));
            System.out.println(user.getUsername());
            System.out.println(String.format("第%d次调用getUsername结束\n********\n", i));
        }
    }

    @Test
    public void test26() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getBeanFactory().registerScope(BeanRefreshScope.SCOPE_REFRESH, BeanRefreshScope.getInstance());
        context.register(MainConfig4.class);
        //刷新mail的配置到Environment
        RefreshConfigUtil.refreshMailPropertySource(context);
        context.refresh();
        MailService mailService = context.getBean(MailService.class);
        System.out.println("配置未更新的情况下,输出3次");
        for (int i = 0; i < 3; i++) { //@1
            System.out.println(mailService);
            TimeUnit.MILLISECONDS.sleep(200);
        }
        System.out.println("模拟3次更新配置效果");
        for (int i = 0; i < 3; i++) { //@2
            RefreshConfigUtil.updateDbConfig(context); //@3
            System.out.println(mailService);
            TimeUnit.MILLISECONDS.sleep(200);
        }
    }

}
