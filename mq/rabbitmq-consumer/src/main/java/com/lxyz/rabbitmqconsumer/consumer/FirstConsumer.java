package com.lxyz.rabbitmqconsumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lbf
 * @date 2021/4/1
 */
@Component
@RabbitListener(queues = "firstQueue")
public class FirstConsumer {


    @RabbitHandler
    public void listeningMsg(String msg) throws Exception{
        Thread.sleep(500);
        System.out.println("first queue get msg ---> " + msg);
    }



}
