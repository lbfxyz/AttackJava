package com.lxyz.attackjava.mq.boot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lbf
 * @date 2021/4/1
 */
@Component
@RabbitListener(queues = "secondQueue")
public class SecondConsumer {


    @RabbitHandler
    public void listeningMsg(String msg) {
        System.out.println("second queue get msg ---> " + msg);
    }


}
