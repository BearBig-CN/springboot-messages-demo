package com.example.bb.message.rabbitmq.sender;

import com.example.bb.common.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * P2P模式的消息发送者
 *
 * @author BB
 * Create: 2020/3/19 0019 9:02
 */
@Slf4j
@Component
public class MessageSenderByP2P implements SendMessageService<String> {

    @Value("${queue.p2p.destination.name}")
    private String destinationName;

    @Autowired
    private RabbitTemplate defaultRabbitTemplate;

    @Override
    public boolean send(String message) {
        log.info("消息生产者(P2P)发送的消息是 = {}", message);
        try {
            defaultRabbitTemplate.convertAndSend(destinationName, message);
            return true;
        } catch (Exception ex) {
            log.error("send message fail", ex);
        }
        return false;
    }
}
