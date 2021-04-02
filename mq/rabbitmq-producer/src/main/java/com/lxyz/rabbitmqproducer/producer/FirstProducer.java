package com.lxyz.rabbitmqproducer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lbf
 * @date 2021/4/1
 */
@Component
public class FirstProducer {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendMsg(String msg) {
        rabbitTemplate.convertAndSend("topic_exchange", "boot.hello", msg);
        rabbitTemplate.convertAndSend("topic_exchange", "boot.hello.test", msg);
    }





}
