package com.lxyz.basics.springboot.firstdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lbf
 * @date 2021/4/12
 */
public class FirstDemoMain {


    public static void main(String[] args) {
//        FirstDemo firstDemo = new FirstDemo();
//        firstDemo.hello();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FirstDemoConfiguration.class);
        FirstDemo firstDemo = applicationContext.getBean(FirstDemo.class);
        firstDemo.hello();
        FirstDemo firstDemo2 = applicationContext.getBean(FirstDemo.class);

        System.out.println(firstDemo);
        System.out.println(firstDemo2);



    }

}
