package com.lxyz.basics.springboot.thirddemo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author lbf
 * @date 2021/4/12
 */
public class CacheImportSelector implements ImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableDefineService.class.getName());
        return new String[0];
    }
}
