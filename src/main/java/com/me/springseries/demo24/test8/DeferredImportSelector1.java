package com.me.springseries.demo24.test8;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.Ordered;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ME
 * @create 2022-08-09 0:13
 */
public class DeferredImportSelector1 implements DeferredImportSelector, Ordered {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Configuration1.class.getName()};
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
