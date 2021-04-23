package com.lxyz.basics.annotations;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lbf
 * @date 2021/4/23
 */
@Configuration
public class ConfigurationOne {


    @Bean
    @ConditionalOnBean(BeanTwo.class)
    public BeanOne beanOne() {
        return new BeanOne();
    }
}
