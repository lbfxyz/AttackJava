package com.lxyz.basics.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lbf
 * @date 2021/4/23
 */
@Configuration
public class ConfigurationTwo {


    @Bean
    public BeanTwo beanTwo() {
        return new BeanTwo();
    }

}
