package com.me.springseries.demo24.test5;

import com.me.springseries.demo24.test4.Service1;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ME
 * @create 2022-08-08 23:50
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
            Service1.class.getName(),
            Module1Config.class.getName(),
            User.class.getName()
        };
    }
}
