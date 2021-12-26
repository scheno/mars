package com.xinghuan.mars.test;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/22 2:32 下午
 */
public class MQTest {

    @Test
    public void testProduce() {
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
