package com.lxyz.basics.springboot.firstdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author lbf
 * @date 2021/4/12
 */
@Configuration
public class FirstDemoConfiguration {


    /**
     * @Scope 可以配置对象是 singleton 还是 prototype
     * @return
     */
    @Bean
    @Scope("singleton")
    public FirstDemo firstDemo() {
        return new FirstDemo();
    }





}
