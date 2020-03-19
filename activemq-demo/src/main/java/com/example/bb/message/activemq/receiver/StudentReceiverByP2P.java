package com.example.bb.message.activemq.receiver;

import com.example.bb.common.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;

/**
 * P2P模式的消息消费者
 * <p>
 * 说明：如果此类有多个实例，则多个实例会同时去消费同一个队列里面的不同消息(类似于并发去消费)
 *
 * @author BB
 * Create: 2020/3/19 0019 9:11
 */
@Slf4j
public class StudentReceiverByP2P {

    private String receiverName;

    public StudentReceiverByP2P(String receiverName) {
        this.receiverName = receiverName;
    }

    @JmsListener(destination = "${queue.p2p.destination.stuName}", containerFactory = "p2pFactory")
    public void receive(Student student) throws InterruptedException {
        log.info("消息消费者-{}-(P2P)接收到的信息是 = {}", this.receiverName, student);
        Thread.sleep(2000L);
    }

}
