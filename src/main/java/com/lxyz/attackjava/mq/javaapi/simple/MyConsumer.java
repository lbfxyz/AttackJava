package com.lxyz.attackjava.mq.javaapi.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author lbf
 * @date 2021/3/31
 */
public class MyConsumer {
    public static final String EXCHANGE_NAME = "test.exchange";
    public static final String QUEUE_NAME = "test_queue";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.100.5");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin@123");

        factory.setVirtualHost("/");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //绑定
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "rabbit.test");
        System.out.println("waiting message ...");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, Charset.defaultCharset());
                System.out.println("received msg: " + msg);
                System.out.println("consumerTag: " + consumerTag);
                System.out.println("deliverTag: " + envelope.getDeliveryTag());
            }
        };

        channel.basicConsume(QUEUE_NAME, true, consumer);

    }


}
