package com.example.bb.message.activemq.sender;

import com.example.bb.common.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * 发布/订阅模式的消息发送者
 *
 * @author BB
 * Create: 2020/3/19 0019 9:02
 */
@Slf4j
@Component
public class MessageSenderByPub implements SendMessageService<String> {

    @Value("${queue.ps.destination.name}")
    private String destinationName;

    @Autowired
    private JmsTemplate pubSubJmsTemplate;

    @Override
    public boolean send(String message) {
        log.info("消息发布者(PubSub)发送的消息是 = {}", message);
        try {
            pubSubJmsTemplate.convertAndSend(destinationName, message);
            return true;
        } catch (Exception ex) {
            log.error("send message fail", ex);
        }
        return false;
    }
}
