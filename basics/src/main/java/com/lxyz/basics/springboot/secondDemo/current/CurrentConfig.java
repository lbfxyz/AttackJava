package com.lxyz.basics.springboot.secondDemo.current;

import com.lxyz.basics.springboot.secondDemo.others.OthersConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lbf
 * @date 2021/4/12
 */
@Configuration
@Import(OthersConfig.class)
public class CurrentConfig {

    @Bean
    public CurrentClass currentClass() {
        return new CurrentClass();
    }

}
