package com.lxyz.basics.springboot.thirddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lbf
 * @date 2021/4/23
 */
@SpringBootApplication
@EnableDefineService(name = {NumService.class})
public class ThirdDemoMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ThirdDemoMain.class, args);
        String[] beanNamesForAnnotation = run.getBeanNamesForAnnotation(EnableDefineService.class);
        for (String name : beanNamesForAnnotation) {
            System.out.println(name);
        }

        System.out.println(run.getBean(LoggerService.class));
        System.out.println(run.getBean(CacheService.class));
        System.out.println(run.getBean(NumService.class));

    }

}
