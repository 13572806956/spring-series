package com.me.springseries.demo24.test7;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ME
 * @create 2022-08-09 0:09
 */
public class ImportSelector1 implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Configuration1.class.getName()};
    }
}
