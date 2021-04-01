package com.lxyz.attackjava.mq.boot.controller;

import com.lxyz.attackjava.mq.boot.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        rabbitTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE, "boot.hello", msg);
    }

}
