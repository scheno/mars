package com.xinghuan.mars.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/22 2:57 下午
 */
@Slf4j
@Component
public class MQHandler {

    public void send(String message) {
        DefaultMQProducer producer = new DefaultMQProducer("producer_mars");
        producer.setNamesrvAddr("10.98.3.234:9876");
        try {
            producer.start();
            producer.send(new Message("emp", "tagA", "第一条消息".getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
