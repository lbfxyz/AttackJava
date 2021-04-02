package com.lxyz.rabbitmqconsumer.base.api;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author lbf
 * @date 2021/3/31
 */
public class MyProducer {


    public static final String EXCHANGE_NAME = "test.exchange";
    public static final String MSG = "hello rabbit mq !";


    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("192.168.100.5");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin@123");

        factory.setVirtualHost("/");


        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();


            channel.basicPublish(EXCHANGE_NAME, "rabbit.test", null, MSG.getBytes());
            channel.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
