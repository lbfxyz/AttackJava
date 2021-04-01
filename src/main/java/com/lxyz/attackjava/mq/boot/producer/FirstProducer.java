package com.lxyz.attackjava.mq.boot.producer;

import com.lxyz.attackjava.mq.boot.config.RabbitMqConfig;
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
        rabbitTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE, "boot.hello", msg);
        rabbitTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE, "boot.hello.test", msg);
    }





}
