package com.me.springseries.lesson001.demo22.test5;

import com.me.springseries.lesson001.demo22.test4.IService;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义过滤器
 */
public class MyFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        Class<?> curClass = null;
        try {
            // 当前被扫描的类
            curClass = Class.forName(metadataReader.getClassMetadata().getClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 判断curClass是否是IService类型
        boolean result = IService.class.isAssignableFrom(curClass);
        return result;
    }
}
