package com.lxyz.basics.springboot.thirddemo;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
* @author lbf
* @date 2021/4/12
**/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CacheImportSelector.class, LoggerDefinitionRegistrar.class})
public @interface EnableDefineService {

    Class<?>[] name() default {};
}
