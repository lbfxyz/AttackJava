package com.lxyz.basics.springboot.firstdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lbf
 * @date 2021/4/12
 */
@ComponentScan
public class FirstDemoComponentScanMain {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FirstDemoComponentScanMain.class);
        FirstDemo firstDemo = applicationContext.getBean(FirstDemo.class);
        firstDemo.hello();
        FirstDemo firstDemo2 = applicationContext.getBean(FirstDemo.class);

        System.out.println(firstDemo);
        System.out.println(firstDemo2);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

    }

}
