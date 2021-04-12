package com.lxyz.basics.springboot.secondDemo.others;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lbf
 * @date 2021/4/12
 */
@Configuration
public class OthersConfig {

    @Bean
    public OthersClass othersClass() {
        return new OthersClass();
    }

}
