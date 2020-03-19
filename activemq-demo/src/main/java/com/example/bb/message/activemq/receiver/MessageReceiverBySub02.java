package com.example.bb.message.activemq.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 发布/订阅模式的消息订阅者02
 * <p>
 * 说明：
 *
 * @author BB
 * Create: 2020/3/19 0019 9:11
 */
@Slf4j
@Component
public class MessageReceiverBySub02 {

    @JmsListener(destination = "${queue.ps.destination.name}", containerFactory = "pubSubFactory")
    public void receive(Object message) throws InterruptedException {
        log.info("消息订阅者02(PS)接收到的信息是 = {}", message);
        Thread.sleep(1000L);
    }

}
