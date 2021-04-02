package com.lxyz.rabbitmqproducer.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lbf
 * @date 2021/4/1
 */
@RestController
@RequestMapping("/mq")
public class MqController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/send")
    public void sendProducerMsg(@RequestParam String msg) {
        rabbitTemplate.convertAndSend("topic_exchange", "boot.hello.hahaha", msg);
    }

}
