package com.me.springseries.demo24.test7;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ME
 * @create 2022-08-09 0:09
 */
public class DeferredImportSelector1 implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Configuration2.class.getName()};
    }
}
