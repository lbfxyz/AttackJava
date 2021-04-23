package com.lxyz.basics.springboot.fourthDemo;

import com.lxyz.core.MyCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author lbf
 * @date 2021/4/23
 */
@SpringBootApplication
public class FourthMain {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FourthMain.class, args);


        MyCore bean = context.getBean(MyCore.class);
        System.out.println(bean);
        System.out.println(bean.study());

    }
}
