package com.lxyz.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lbf
 * @date 2021/4/23
 */
@Configuration
public class MyConfiguration {

    @Bean
    public MyCore lxyzCore() {
        return new MyCore();
    }

}
