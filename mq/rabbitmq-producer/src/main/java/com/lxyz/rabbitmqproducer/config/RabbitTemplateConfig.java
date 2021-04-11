package com.lxyz.rabbitmqproducer.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lbf
 * @date 2021/4/5
 */
@Configuration
public class RabbitTemplateConfig {


    @Bean
    public RabbitTemplate setConfirm() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();

        return rabbitTemplate;
    }





}
