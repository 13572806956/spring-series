package com.me.springseries.demo24.test4;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ME
 * @create 2022-08-08 23:39
 */
public class MyImportBeanDefinitionRegistar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AbstractBeanDefinition service1BeanDinition  =
                BeanDefinitionBuilder.genericBeanDefinition(Service1.class).getBeanDefinition();
        registry.registerBeanDefinition("service1", service1BeanDinition);
        AbstractBeanDefinition service2BeanDinition =
                BeanDefinitionBuilder.genericBeanDefinition(Service2.class).getBeanDefinition();
        registry.registerBeanDefinition("service2", service2BeanDinition);
    }
}
