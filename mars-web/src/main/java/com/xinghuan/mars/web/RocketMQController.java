package com.xinghuan.mars.web;

import com.xinghuan.mars.handler.MQHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/22 2:58 下午
 */
@RestController
public class RocketMQController {

    @Autowired
    private MQHandler mqHandler;

    @PostMapping("/mq/send")
    public void send(@RequestBody String message) {
        mqHandler.send(message);
    }
}
