package com.lxyz.attackjava.mq.boot.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FirstProducerTest {

    @Autowired
    private FirstProducer firstProducer;

    @Test
    void sendMsg() {
        String msg = "hell rabbit";
        firstProducer.sendMsg(msg);
    }
}
