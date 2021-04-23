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

        Class[] clazz = (Class[]) annotationAttributes.get("name");
        if (clazz.length > 0) {
            String[] s = new String[clazz.length];
            for (int i = 0; i < clazz.length; i++) {
                s[i] = clazz[i].getName();
            }
            return s;
        }

        return new String[]{CacheService.class.getName()};
    }
}
