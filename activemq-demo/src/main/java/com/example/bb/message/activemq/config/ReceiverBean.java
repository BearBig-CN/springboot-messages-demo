package com.example.bb.message.activemq.config;

import com.example.bb.message.activemq.receiver.MessageReceiverByP2P;
import com.example.bb.message.activemq.receiver.StudentReceiverByP2P;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 接收者
 *
 * @author BB
 * Create: 2020/3/19 0019 11:15
 */
@Configuration
public class ReceiverBean {

    @Bean
    public MessageReceiverByP2P messageReceiverByP2P01() {
        return new MessageReceiverByP2P("01");
    }

    @Bean
    public MessageReceiverByP2P messageReceiverByP2P02() {
        return new MessageReceiverByP2P("02");
    }

    @Bean
    public StudentReceiverByP2P studentReceiverByP2P() {
        return new StudentReceiverByP2P("03");
    }
}
