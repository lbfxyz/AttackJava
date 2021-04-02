package com.lxyz.rabbitmqconsumer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lbf
 * @date 2021/4/1
 */
@Configuration
public class RabbitMqConfig {

    public static final String DIRECT_EXCHANGE = "direct_exchange";
    public static final String TOPIC_EXCHANGE = "topic_exchange";

    public static final String FIRST_QUEUE = "firstQueue";
    public static final String SECOND_QUEUE = "secondQueue";
    public static final String THIRD_QUEUE = "thirdQueue";


    @Bean("directExchange")
    public Exchange buildDirectExchange() {
        return ExchangeBuilder.directExchange(DIRECT_EXCHANGE).build();
    }

    @Bean("topicExchange")
    public Exchange buildTopicExchange() {
        return ExchangeBuilder.topicExchange(TOPIC_EXCHANGE).build();
    }


    @Bean("firstQueue")
    public Queue buildFirstQueue() {
//        Map<String, Object> args = new HashMap<>(16);
//        args.put("x-message-ttl", 60);
        return QueueBuilder.durable(FIRST_QUEUE).ttl(60).build();
    }

    @Bean("secondQueue")
    public Queue buildSecondQueue() {
        return QueueBuilder.durable(SECOND_QUEUE).ttl(240).build();
    }

    @Bean("thirdQueue")
    public Queue buildThirdQueue() {
        return QueueBuilder.durable(THIRD_QUEUE).build();
    }


    /*
    将队列和交换机绑定
     */

    @Bean
    public Binding bindingFirst(@Qualifier("firstQueue") Queue queue,
                                @Qualifier("topicExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }

    @Bean
    public Binding bindingSecond(@Qualifier("secondQueue") Queue queue,
                                 @Qualifier("topicExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("boot.hello.*").noargs();
    }





}
